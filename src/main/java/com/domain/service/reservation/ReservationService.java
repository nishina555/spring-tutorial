package com.domain.service.reservation;

import com.domain.model.*;
import com.domain.repository.reservation.ReservationRepository;
import com.domain.repository.room.ReservableRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Created by nishina on 2016/09/29.
 */
@Service
@Transactional
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservableRoomRepository reservableRoomRepository;

    public Reservation reserve(Reservation reservation) {
        ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();
        ReservableRoom reservable = reservableRoomRepository.findOne(reservableRoomId);
        if ( reservable == null) {
          throw new UnavailableReservationException("入力の日付・部屋の組み合わせは予約できません");
        }

        boolean overlap = reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)
                .stream()
                .anyMatch(x -> x.overlap(reservation));
        if (overlap) {
            throw new AlreadyReservedException("入力の時間帯はすでに予約済みです");
        }
        reservationRepository.save(reservation);
        return reservation;
    }

    public void cancel(Integer reservationId, User requestUser) {
        Reservation reservation = reservationRepository.findOne(reservationId);
        if (RoleName.ADMIN != requestUser.getRoleName() &&
                !Objects.equals(reservation.getUser().getUserId(), requestUser.getUserId())) {
            throw new IllegalStateException("要求されたキャンセルは許可できません");
        }
        reservationRepository.delete(reservation);
    }

    public List<Reservation> findReservation(ReservableRoomId reservableRoomId) {
        return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
    }
}

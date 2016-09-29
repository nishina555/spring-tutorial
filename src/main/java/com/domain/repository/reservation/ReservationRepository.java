package com.domain.repository.reservation;

import com.domain.model.ReservableRoomId;
import com.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nishina on 2016/09/29.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    List<Reservation> findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(ReservableRoomId reservableRoomId);
}

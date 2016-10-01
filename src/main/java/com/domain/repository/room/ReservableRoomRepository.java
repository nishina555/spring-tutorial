package com.domain.repository.room;

import com.domain.model.ReservableRoom;
import com.domain.model.ReservableRoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by nishina on 2016/09/28.
 */
public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId>{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    ReservableRoom findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);

    List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);
}

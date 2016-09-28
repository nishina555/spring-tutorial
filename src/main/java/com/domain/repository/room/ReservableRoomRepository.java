package com.domain.repository.room;

import com.domain.model.ReservableRoom;
import com.domain.model.ReservableRoomId;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

/**
 * Created by nishina on 2016/09/28.
 */
public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId>{
    List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);
}

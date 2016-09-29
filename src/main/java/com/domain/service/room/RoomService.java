package com.domain.service.room;

import com.domain.model.MeetingRoom;
import com.domain.model.ReservableRoom;
import com.domain.repository.room.MeetingRoomRepository;
import com.domain.repository.room.ReservableRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by nishina on 2016/09/28.
 */
@Service
@Transactional
public class RoomService {
    @Autowired
    ReservableRoomRepository reservableRoomRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    public List<ReservableRoom> findReservableRooms(LocalDate date) {
        return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
    }

    public MeetingRoom findMeetingRoom(Integer roomId) {
        return meetingRoomRepository.findOne(roomId);
    }
}

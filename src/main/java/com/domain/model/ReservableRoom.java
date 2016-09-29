package com.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nishina on 2016/09/27.
 */
@Entity
@Data
public class ReservableRoom implements Serializable {
    @EmbeddedId
    private ReservableRoomId reservableRoomId;

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    @MapsId("roomId")
    private MeetingRoom meetingRoom;

    public ReservableRoom(ReservableRoomId reservationRoomId) {
        this.reservableRoomId = reservationRoomId;
    }

    public ReservableRoom() {
    }
}

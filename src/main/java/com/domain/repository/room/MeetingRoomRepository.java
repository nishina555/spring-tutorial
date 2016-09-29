package com.domain.repository.room;

import com.domain.model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nishina on 2016/09/29.
 */
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {
}

package com.example.reservation;

import com.domain.model.ReservableRoomId;
import com.domain.model.Reservation;
import com.domain.model.RoleName;
import com.domain.model.User;
import com.domain.service.reservation.ReservationService;
import com.domain.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nishina on 2016/09/29.
 */
@Controller
@RequestMapping("reservations/{date}/{roomId}")
public class ReservationsController {
    @Autowired
    RoomService roomService;
    @Autowired
    ReservationService reservationService;

    @ModelAttribute
    ReservationForm setUpForm() {
        ReservationForm form = new ReservationForm();
        form.setStartTime(LocalTime.of(9,0));
        form.setEndTime(LocalTime.of(10,0));
        return form;
    }

    @GetMapping
    String reserveForm(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
                       @PathVariable("roomId") Integer roomId, Model model) {
        ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);
        List<Reservation> reservations = reservationService.findReservation(reservableRoomId);

        List<LocalTime> timeList =
                Stream.iterate(LocalTime.of(0, 0), t -> t.plusMinutes(30))
                        .limit(24 * 2)
                .collect(Collectors.toList());

        model.addAttribute("room", roomService.findMeetingRoom(roomId));
        model.addAttribute("reservations", reservations);
        model.addAttribute("timeList", timeList);
        model.addAttribute("user", dummyUser());
        return "reservation/reserveForm";
    }

    private User dummyUser() {
        User user = new User();
        user.setUserId("taro-yamada");
        user.setFirstName("太郎");
        user.setLastName("山田");
        user.setRoleName(RoleName.USER);
        return user;
    }
}

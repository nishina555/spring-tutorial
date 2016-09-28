package com.example.room;

import com.domain.model.ReservableRoom;
import com.domain.service.room.RoomService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

/**
 * Created by nishina on 2016/09/28.
 */
@Controller
@RequestMapping("rooms")
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping
    String listRomms(Model model) {
        LocalDate today = LocalDate.now();
        List<ReservableRoom> rooms = roomService.findReservableRooms(today);
        model.addAttribute("date", today);
        model.addAttribute("rooms", rooms);
        return "model/listRooms";
    }
}

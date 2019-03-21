package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Room;
import com.toycar.hotelserver.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomController {
    @Autowired(required = false)
    RoomService roomService;

    @RequestMapping("/addRoom")
    public String addRoom(Room room){
        return  roomService.addRoom(room);
    }

    @RequestMapping("/DeleteRoom")
    public String deleteRoom(Room room){
        return  roomService.deleteRoom(room.getRoomId());
    }

    @RequestMapping("/UpdateRoom")
    public String updateRoom(Room room){
        return  roomService.updateRoom(room);
    }
}

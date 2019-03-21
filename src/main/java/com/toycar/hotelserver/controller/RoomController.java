package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Room;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomController {
    @Autowired(required = false)
    RoomService roomService;

    @RequestMapping("/room/add")
    public String addRoom(Room room){
        return  roomService.addRoom(room);
    }

    @RequestMapping("/room/delete")
    public String deleteRoom(Room room){
        return  roomService.deleteRoom(room.getRoomId());
    }

    @RequestMapping("/room/update")
    public String updateRoom(Room room){
        return  roomService.updateRoom(room);
    }

    @RequestMapping("/room/findByDate")
    public String findRoomByDate(RoomOrder roomOrder){
        return roomService.findRoomByDate(roomOrder);
    }
}

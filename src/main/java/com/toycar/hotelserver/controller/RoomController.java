package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Room;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired(required = false)
    RoomService roomService;

    @RequestMapping("/hotel/staff/room/add")
    public String addRoom(Room room){
        return  roomService.addRoom(room);
    }

    @RequestMapping("/hotel/staff/room/delete")
    public String deleteRoom(Room room){
        return  roomService.deleteRoom(room);
    }

    @RequestMapping("/hotel/staff/room/update")
    public String updateRoom(Room room){
        return  roomService.updateRoom(room);
    }

    @RequestMapping("/hotel/room/findByDate")
    public String findRoomByDate(RoomOrder roomOrder){
        System.out.println(roomOrder.getOrderId());
        return roomService.findRoomByDate(roomOrder);
    }
}

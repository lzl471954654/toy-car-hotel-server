package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.service.RoomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomOrderController {

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/order/add")
    public RoomOrder addOrder(RoomOrder roomOrder){
        roomOrderService.addRoomOrder(roomOrder);
        return roomOrder;
    }

}

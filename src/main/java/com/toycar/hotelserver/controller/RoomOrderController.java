package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.service.RoomOrderService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomOrderController {

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/roomOrder/add")
    public String addOrder(RoomOrder roomOrder){
        return roomOrderService.addRoomOrder(roomOrder);
    }

    @RequestMapping("/roomOrder/delete")
    public String deleteOrder(RoomOrder roomOrder){
        int count = roomOrderService.deleteRoomOrderByOrderId(roomOrder);
        int code = count == 1 ? 1 : 0;
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,null).toString();
    }

    @RequestMapping("/roomOrder/update")
    public String updateOrder(RoomOrder roomOrder){

        return null;
    }


}

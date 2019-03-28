package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.service.RoomOrderService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomOrderController {

    @Autowired
    private RoomOrderService roomOrderService;

    @RequestMapping("/hotel/staff/roomOrder/findAll")
    public String findAll(){
        List<RoomOrder> list = roomOrderService.findAll();
        return JSONUtil
                .generateJsonObjectWithCodeAndObj(list.size()>0?1:0,list)
                .toString();
    }

    @RequestMapping("hotel/roomOrder/findById")
    public String findById(RoomOrder roomOrder){
        RoomOrder order = roomOrderService.findRoomOrderById(roomOrder);
        return JSONUtil
                .generateJsonObjectWithCodeAndObj(order == null ? 0 : 1,order)
                .toString();
    }

    @RequestMapping("/hotel/roomOrder/add")
    public String addOrder(RoomOrder roomOrder){
        return roomOrderService.addRoomOrder(roomOrder);
    }

    @RequestMapping("/hotel/roomOrder/delete")
    public String deleteOrder(RoomOrder roomOrder){
        int count = roomOrderService.deleteRoomOrderByOrderId(roomOrder);
        int code = count == 1 ? 1 : 0;
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,null).toString();
    }

    @RequestMapping("/hotel/roomOrder/update")
    public String updateOrder(RoomOrder roomOrder){
        int code = roomOrderService.updateOrder(roomOrder);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,roomOrder).toString();
    }


}

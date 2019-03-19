package com.toycar.hotelserver.service;

import com.toycar.hotelserver.manager.IDManager;
import com.toycar.hotelserver.manager.RoomManager;
import com.toycar.hotelserver.mapper.RoomOrderMapper;
import com.toycar.hotelserver.pojo.RoomOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomOrderService {

    @Autowired(required = false)
    private RoomOrderMapper mapper;

    public int deleteRoomOrderByOrderId(RoomOrder roomOrder){
        return mapper.deleteByPrimaryKey(roomOrder.getOrderId());
    }

    public RoomOrder addRoomOrder(RoomOrder roomOrder){
        RoomManager.lockRoom(roomOrder.getRoomId());
        roomOrder.setOrderId(IDManager.generateRoomOrderId(roomOrder));
        mapper.insert(roomOrder);
        RoomManager.releaseRoom(roomOrder.getRoomId());
        return roomOrder;
    }



}

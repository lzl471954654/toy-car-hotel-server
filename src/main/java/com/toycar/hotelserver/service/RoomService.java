package com.toycar.hotelserver.service;


import com.google.gson.JsonObject;
import com.toycar.hotelserver.mapper.RoomMapper;
import com.toycar.hotelserver.mapper.RoomOrderMapper;
import com.toycar.hotelserver.mapper.UserMapper;
import com.toycar.hotelserver.pojo.Room;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.pojo.User;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {
    @Autowired(required = false)
    private RoomMapper roomMapper;

    @Autowired(required = false)
    private RoomOrderMapper roomOrderMapper;

    public String addRoom(Room room){
        int n = roomMapper.insertSelective(room);
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(n,null);
        return object.toString();
    }

    public String deleteRoom(String roomId){
        RoomOrder roomOrder = roomOrderMapper.selectByRoomId(roomId);
        int n = 0;
        if (roomOrder != null) {
            n = roomMapper.deleteByPrimaryKey(roomId);
        }
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(n,null);
        return object.toString();
    }

/*
    public String  updateRoomType(String roomId,Integer roomType){
        Room room = new Room();
        room.setRoomId(roomId);
        room.setRoomType(roomType);
        int n = roomMapper.updateByPrimaryKeySelective(room);
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(n,null);
        return object.toString();
    }
*/

    public String updateRoom(Room room){
        int n = roomMapper.updateByPrimaryKey(room);
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(n,null);
        return object.toString();
    }

   /* public String findRoomByParameter(String parameter,Integer type) {
        List<Room> roomList = null;
        roomList = roomMapper.selectByType(type);
        int n = 0;
        if (roomList.size() != 0){
         n = 1;
        }
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(n,roomList);
        return object.toString();
    }
*/
    /*public String findRoomByParameter(String parameter,BigDecimal price) {
        List<Room> roomList = null;
        roomList = roomMapper.selectByPrice(price);
        int n = 0;
        if (roomList.size() != 0){
            n = 1;
        }
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(n,roomList);
        return object.toString();
    }*/

    public String findRoomByDate(Date start,Date end){
        RoomOrder roomOrder = new RoomOrder();
        roomOrder.setStart(start);
        roomOrder.setEnd(end);
        List<RoomOrder> roomOrderList = roomOrderMapper.checkStartTimeAndEndTimeContainsOrder(roomOrder);
        List<Room> roomList = roomMapper.selectAll();
        for (RoomOrder order : roomOrderList) {
            roomList.remove(order.getRoomId());
        }
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(0,roomList);
        return object.toString();
    }
}

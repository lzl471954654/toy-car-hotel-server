package com.toycar.hotelserver.service;


import com.google.gson.JsonObject;
import com.toycar.hotelserver.manager.RoomManager;
import com.toycar.hotelserver.mapper.RoomMapper;
import com.toycar.hotelserver.mapper.RoomOrderMapper;
import com.toycar.hotelserver.pojo.Room;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    @Autowired(required = false)
    private RoomMapper roomMapper;

    @Autowired(required = false)
    private RoomOrderMapper roomOrderMapper;

    public String addRoom(Room room) {
        int n = roomMapper.insertSelective(room);
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(n, "");
        return object.toString();
    }

    public String deleteRoom(Room room) {
        int code = 1;
        if (RoomManager.lockRoom(room.getRoomId())) {
            try {
                RoomOrder roomOrder = roomOrderMapper.selectByRoomId(room.getRoomId());

                if (roomOrder == null) {
                   int n = roomMapper.deleteByPrimaryKey(room.getRoomId());
                   if (n == 0){
                       code = -1;
                   }
                }
            } finally {
                RoomManager.releaseRoom(room.getRoomId());
            }
        }else {
            code = -3;
        }
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(code, "");
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

    public String updateRoom(Room room) {
        int code = 1;
        if (RoomManager.lockRoom(room.getRoomId())) {
            try {
                int n = roomMapper.updateByPrimaryKey(room);
                if (n == 0) {
                    code = -1;
                }
            } finally {
                RoomManager.releaseRoom(room.getRoomId());
            }
        }else {
            code = -3;
        }
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(code, "");
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

        public String findRoomByDate (RoomOrder roomOrder){
            List<RoomOrder> roomOrderList = roomOrderMapper.checkStartTimeAndEndTimeContainsOrder(roomOrder);
            List<Room> roomList = roomMapper.selectAll();
            for (RoomOrder order : roomOrderList) {
                for (int i = 0; i < roomList.size(); i++) {
                    if (roomList.get(i).getRoomId().equals(order.getRoomId())) {
                        roomList.remove(i);
                    }
                }
            }
            JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(1, roomList);
            return object.toString();
        }
}

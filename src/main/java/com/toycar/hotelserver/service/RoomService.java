package com.toycar.hotelserver.service;


import com.toycar.hotelserver.mapper.RoomMapper;
import com.toycar.hotelserver.mapper.RoomOrderMapper;
import com.toycar.hotelserver.mapper.UserMapper;
import com.toycar.hotelserver.pojo.Room;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoomService {
    @Autowired(required = false)
    private RoomMapper roomMapper;

    @Autowired(required = false)
    private RoomOrderMapper roomOrderMapper;

    public int addRoom(Room room, User user){
        int n = roomMapper.insert(room);
        return n;
    }

    public int deleteRoom(String roomId){
        RoomOrder roomOrder = roomOrderMapper.selectByRoomId(roomId);
        if (roomOrder != null){
            int n = roomMapper.deleteByPrimaryKey(roomId);
            return n;
        }else {
            return 0;
        }
    }

    public int updateRoomType(String roomId,Integer roomType){
        Room room = new Room();
        room.setRoomId(roomId);
        room.setRoomType(roomType);
        int n = roomMapper.updateByPrimaryKeySelective(room);
        return n;
    }

    public int updateRoomAll(Room room){
        int n = roomMapper.updateByPrimaryKey(room);
        return n;
    }

    public List<Room> findRoomByParameter(String parameter,String parameterName) {
        List<Room> roomList = null;
        if (parameterName.equals("类型")) {
            Integer roomType = Integer.valueOf(parameter);
            roomList = roomMapper.selectByType(roomType);
            return roomList;
        } else if (parameterName.equals("状态")) {
            Integer roomStatus = Integer.valueOf(parameter);
            roomList = roomMapper.selectByStatus(roomStatus);
            return roomList;
        } else if (parameterName.equals("价格")) {
            /*BigDecimal roomPrice = BigDecimal.*/
            return roomList;
        }

        return null;
    }
}

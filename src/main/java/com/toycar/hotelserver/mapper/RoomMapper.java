package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Room;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(String roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(String roomId);

    List<Room> selectAll();

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}
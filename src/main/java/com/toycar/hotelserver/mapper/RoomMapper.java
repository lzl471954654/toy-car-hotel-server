package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Room;

public interface RoomMapper {
    int deleteByPrimaryKey(String roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(String roomId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}
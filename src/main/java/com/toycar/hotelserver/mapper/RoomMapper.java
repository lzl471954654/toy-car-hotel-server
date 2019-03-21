package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Room;
import com.toycar.hotelserver.pojo.RoomOrder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(String roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(String roomId);

    List<Room> selectAll();

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> selectByType(Integer roomType);

    List<Room> selectByStatus(Integer roomStatus);

    List<Room> selectByPrice(BigDecimal roomPrice);

}
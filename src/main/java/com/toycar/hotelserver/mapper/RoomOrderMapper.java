package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.RoomOrder;

import java.util.List;

public interface RoomOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(RoomOrder record);

    int insertSelective(RoomOrder record);

    RoomOrder selectByPrimaryKey(String orderId);

    List<RoomOrder> selectAll();

    int updateByPrimaryKeySelective(RoomOrder record);

    int updateByPrimaryKey(RoomOrder record);
}
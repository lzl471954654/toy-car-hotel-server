package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.OrderType;

import java.util.List;

public interface OrderTypeMapper {
    int deleteByPrimaryKey(Integer orderType);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    OrderType selectByPrimaryKey(Integer orderType);

    List<OrderType> selectAll();

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);
}
package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.OrderType;

public interface OrderTypeMapper {
    int deleteByPrimaryKey(Integer orderType);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    OrderType selectByPrimaryKey(Integer orderType);

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);
}
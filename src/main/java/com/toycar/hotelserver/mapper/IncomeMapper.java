package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Income;

import java.util.List;

public interface IncomeMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(String orderId);

    List<Income> selectAll();

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
}
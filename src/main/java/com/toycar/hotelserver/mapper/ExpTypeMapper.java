package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.ExpType;

public interface ExpTypeMapper {
    int deleteByPrimaryKey(Integer expType);

    int insert(ExpType record);

    int insertSelective(ExpType record);

    ExpType selectByPrimaryKey(Integer expType);

    int updateByPrimaryKeySelective(ExpType record);

    int updateByPrimaryKey(ExpType record);
}
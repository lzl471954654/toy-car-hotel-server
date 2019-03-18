package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Expenditure;

public interface ExpenditureMapper {
    int deleteByPrimaryKey(String expId);

    int insert(Expenditure record);

    int insertSelective(Expenditure record);

    Expenditure selectByPrimaryKey(String expId);

    int updateByPrimaryKeySelective(Expenditure record);

    int updateByPrimaryKey(Expenditure record);
}
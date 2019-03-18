package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(String staffAccount);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String staffAccount);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}
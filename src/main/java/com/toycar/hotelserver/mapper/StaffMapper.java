package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Staff;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(String staffAccount);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String staffAccount);

    List<Staff> selectAll();

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}
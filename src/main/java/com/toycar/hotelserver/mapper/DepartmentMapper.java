package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String deptName);

    int insert(Department record);

    int insertSelective(Department record);
}
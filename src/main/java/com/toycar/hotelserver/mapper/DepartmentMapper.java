package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    Department selectByPrimaryKey(Department department);

    List<Department> selectAll();

    int deleteByPrimaryKey(String deptName);

    int insert(Department record);

    int insertSelective(Department record);
}
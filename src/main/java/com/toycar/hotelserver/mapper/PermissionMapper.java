package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionType);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionType);

    List<Permission> selectAll();

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}
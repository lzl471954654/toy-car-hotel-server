package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userAccount);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userAccount);

    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
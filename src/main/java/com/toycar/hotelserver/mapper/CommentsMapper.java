package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);
}
package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Comments;

import java.util.List;

public interface CommentsMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(String orderId);

    List<Comments> selectAll();

    int updateByPrimaryKeySelective(Comments record);  //根据订单号修改评论

    int updateByPrimaryKeyWithBLOBs(Comments record);  //根据订单号修改评论
}
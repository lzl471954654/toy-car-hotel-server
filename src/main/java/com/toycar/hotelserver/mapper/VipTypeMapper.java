package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.VipType;

import java.util.List;

public interface VipTypeMapper {
    int deleteByPrimaryKey(Integer vipType);

    int insert(VipType record);

    int insertSelective(VipType record);

    VipType selectByPrimaryKey(Integer vipType);

    List<VipType> selectAll();

    int updateByPrimaryKeySelective(VipType record);

    int updateByPrimaryKey(VipType record);
}
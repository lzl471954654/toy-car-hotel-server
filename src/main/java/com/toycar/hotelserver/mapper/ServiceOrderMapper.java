package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.ServiceOrder;

import java.util.List;

public interface ServiceOrderMapper {
    int deleteByPrimaryKey(String serviceId);

    int insert(ServiceOrder record);

    int insertSelective(ServiceOrder record);

    ServiceOrder selectByPrimaryKey(String serviceId);

    List<ServiceOrder> selectAll();

    int updateByPrimaryKeySelective(ServiceOrder record);

    int updateByPrimaryKey(ServiceOrder record);
}
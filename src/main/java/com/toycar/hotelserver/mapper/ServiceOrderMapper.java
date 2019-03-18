package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.ServiceOrder;

public interface ServiceOrderMapper {
    int deleteByPrimaryKey(String serviceId);

    int insert(ServiceOrder record);

    int insertSelective(ServiceOrder record);

    ServiceOrder selectByPrimaryKey(String serviceId);

    int updateByPrimaryKeySelective(ServiceOrder record);

    int updateByPrimaryKey(ServiceOrder record);
}
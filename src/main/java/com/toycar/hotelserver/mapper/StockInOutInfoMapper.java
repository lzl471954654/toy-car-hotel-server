package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.StockInOutInfo;
import com.toycar.hotelserver.pojo.StockInOutInfoKey;

public interface StockInOutInfoMapper {
    int deleteByPrimaryKey(StockInOutInfoKey key);

    int insert(StockInOutInfo record);

    int insertSelective(StockInOutInfo record);

    StockInOutInfo selectByPrimaryKey(StockInOutInfoKey key);

    int updateByPrimaryKeySelective(StockInOutInfo record);

    int updateByPrimaryKey(StockInOutInfo record);
}
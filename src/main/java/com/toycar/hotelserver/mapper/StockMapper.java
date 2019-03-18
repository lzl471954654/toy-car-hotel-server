package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StockMapper {
    int deleteByPrimaryKey(String stockName);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(String stockName);

    List<Stock> selectAll();

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}
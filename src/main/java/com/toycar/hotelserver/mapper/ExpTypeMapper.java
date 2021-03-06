package com.toycar.hotelserver.mapper;

import com.toycar.hotelserver.pojo.ExpType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ExpTypeMapper {
    int deleteByPrimaryKey(Integer expType);
    @Transactional
    int insert(ExpType record);

    int insertSelective(ExpType record);

    ExpType selectByPrimaryKey(Integer expType);

    List<ExpType> selectAll();

    int updateByPrimaryKeySelective(ExpType record);

    int updateByPrimaryKey(ExpType record);
}
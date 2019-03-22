package com.toycar.hotelserver.service;

import com.toycar.hotelserver.mapper.ExpenditureMapper;
import com.toycar.hotelserver.mapper.IncomeMapper;
import com.toycar.hotelserver.pojo.Expenditure;
import com.toycar.hotelserver.pojo.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeExpService {

    @Autowired(required = false)
    private IncomeMapper incomeMapper;

    @Autowired(required = false)
    private ExpenditureMapper expenditureMapper;

    public List<Income> getIncomeAll(){
        return incomeMapper.selectAll();
    }

    public List<Expenditure> getExpAll(){
        return expenditureMapper.selectAll();
    }

    public Income getIncomeById(Income income){
        return incomeMapper.selectByPrimaryKey(income.getOrderId());
    }

    public Expenditure getExpById(Expenditure expenditure){
        return expenditureMapper.selectByPrimaryKey(expenditure.getExpId());
    }
}

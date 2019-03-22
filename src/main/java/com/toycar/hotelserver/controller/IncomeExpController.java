package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Expenditure;
import com.toycar.hotelserver.pojo.Income;
import com.toycar.hotelserver.service.IncomeExpService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomeExpController {

    @Autowired
    private IncomeExpService service;

    @RequestMapping("/hotel/staff/getIncome/all")
    public String getAllIncome(){
        List<Income> list = service.getIncomeAll();
        return JSONUtil.generateJsonObjectWithCodeAndObj(list.size() > 0 ? 1 : 0,list).toString();
    }

    @RequestMapping("/hotel/staff/getExp/all")
    public String getExpAll(){
        List<Expenditure> list = service.getExpAll();
        return JSONUtil.generateJsonObjectWithCodeAndObj(list.size() > 0 ? 1 : 0,list).toString();
    }

    @RequestMapping("/hotel/staff/getIncomeById")
    public String getIncomeById(Income income){
        income = service.getIncomeById(income);
        return JSONUtil.generateJsonObjectWithCodeAndObj(income == null ? 0 : 1,income).toString();
    }

    @RequestMapping("/hotel/staff/getExpById")
    public String getIncomeById(Expenditure exp){
        exp = service.getExpById(exp);
        return JSONUtil.generateJsonObjectWithCodeAndObj(exp == null ? 0 : 1,exp).toString();
    }

}

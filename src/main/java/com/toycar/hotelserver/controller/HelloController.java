package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.mapper.StaffMapper;
import com.toycar.hotelserver.mapper.StockMapper;
import com.toycar.hotelserver.pojo.Staff;
import com.toycar.hotelserver.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HelloController {

    @Autowired(required = false)
    private StockMapper stockMapper;

    @ResponseBody
    @RequestMapping("/hello")
    public List<Stock> findAll(){
        List<Stock> list = stockMapper.selectAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("/hello2")
    public Stock findOne(){
        Stock stock = stockMapper.selectByPrimaryKey("中性笔");
        System.out.println(stock);
        return stock;
    }

}

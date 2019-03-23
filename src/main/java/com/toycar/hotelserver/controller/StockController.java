package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Stock;
import com.toycar.hotelserver.pojo.StockInOutInfo;
import com.toycar.hotelserver.service.StockService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired(required = false)
    StockService stockService;

    @RequestMapping("/hotel/staff/stock/add")
    public String addStockTpe(Stock stock){
        int code = stockService.addStockType(stock);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code, stock).toString();
    }
  /*  @RequestMapping("/stock/delete")
    public String deleteStockTpe(Stock stock){
        int code = stockService.deleteStockType(stock);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code, null).toString();
    }*/

    @RequestMapping("/hotel/staff/stock/inOrOutStock")
    public String inOrOutStock(StockInOutInfo stockInOutInfo){

        return stockService.inOrOutStock(stockInOutInfo);
    }

    @RequestMapping("/hotel/staff/stock/findAll")
    public String findAll(){
        List<StockInOutInfo>list = stockService.findAll();
        return JSONUtil.generateJsonObjectWithCodeAndObj(list.size()>0?-1:1,list).toString();
    }
}

package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Stock;
import com.toycar.hotelserver.pojo.StockInOutInfo;
import com.toycar.hotelserver.service.StockService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired(required = false)
    StockService stockService;

    @RequestMapping("/hotel/staff/stock/add")
    public String addStockTpe(Stock stock){
        int code = stockService.addStockType(stock);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code, null).toString();
    }
  /*  @RequestMapping("/stock/delete")
    public String deleteStockTpe(Stock stock){
        int code = stockService.deleteStockType(stock);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code, null).toString();
    }*/

    @RequestMapping("/hotel/staff/stock/inOrOutStock")
    public String inOrOutStock(StockInOutInfo stockInOutInfo){
        int code = stockService.inOrOutStock(stockInOutInfo);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code, null).toString();
    }
}

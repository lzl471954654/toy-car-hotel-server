package com.toycar.hotelserver.service;

import com.toycar.hotelserver.manager.IDManager;
import com.toycar.hotelserver.manager.StockManager;
import com.toycar.hotelserver.mapper.StockInOutInfoMapper;
import com.toycar.hotelserver.mapper.StockMapper;
import com.toycar.hotelserver.pojo.Stock;
import com.toycar.hotelserver.pojo.StockInOutInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StockService {
    @Autowired(required = false)
    private StockMapper stockMapper;

    @Autowired(required = false)
    private StockInOutInfoMapper stockInOutInfoMapper;


    public int addStockType(Stock stock){
        int n = stockMapper.insertSelective(stock);
        return n;
    }

    public int deleteStockType(Stock stock){
        int n = -3;
        if (StockManager.lockRoom(stock.getStockName())){
            try {
                Stock  stock1 = stockMapper.selectByPrimaryKey(stock.getStockName());
                if(stock1==null){
                    n = -1; //未找到对应类型
                }else if (stock1.getStockCount()>0){
                    n = -2; //删除时库存不能为0
                }else {
                    n = 1;
                    stockMapper.deleteByPrimaryKey(stock.getStockName());
                }
            }finally {
                StockManager.releaseRoom(stock.getStockName());
            }
        }

        return n;
    }

    private int updateStock(Stock stock){
        int n = -3;
        if (StockManager.lockRoom(stock.getStockName())){
            try {
                 n = stockMapper.updateByPrimaryKeySelective(stock);
            }finally {
                StockManager.releaseRoom(stock.getStockName());
            }
        }
        return  n;
    }


    public int inOrOutStock(StockInOutInfo stockInOutInfo){
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            stockInOutInfo.setStockDate(stf.parse(stf.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        stockInOutInfo.setStockId(IDManager.generateStockId(stockInOutInfo));
        stockInOutInfoMapper.insertSelective(stockInOutInfo);
        int n = -3;
        Stock stock = stockMapper.selectByPrimaryKey(stockInOutInfo.getStockName());
        if (stock != null){
            if (stockInOutInfo.getStockType() == 1){
                stock.setStockCount(stock.getStockCount() + stockInOutInfo.getStockCount());
            }else{
                stock.setStockCount(stock.getStockCount() - stockInOutInfo.getStockCount());
            }
            n = updateStock(stock);
        }
        return n;
    }

}

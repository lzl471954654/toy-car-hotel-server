package com.toycar.hotelserver.service;

import com.toycar.hotelserver.manager.IDManager;
import com.toycar.hotelserver.manager.StockManager;
import com.toycar.hotelserver.mapper.StockInOutInfoMapper;
import com.toycar.hotelserver.mapper.StockMapper;
import com.toycar.hotelserver.pojo.Stock;
import com.toycar.hotelserver.pojo.StockInOutInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        stock.setStockCount(0);
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


    @Transactional(rollbackFor = Exception.class)
    public int inOrOutStock(StockInOutInfo stockInOutInfo){
        Date date = new Date(System.currentTimeMillis());
        stockInOutInfo.setStockDate(date);
        stockInOutInfo.setStockId(IDManager.generateStockId(stockInOutInfo));
        if (stockMapper.selectByPrimaryKey(stockInOutInfo.getStockName())==null){
            Stock stock1 = new Stock();
            stock1.setStockName(stockInOutInfo.getStockName());
            addStockType(stock1);
        }
        if (stockInOutInfoMapper.insertSelective(stockInOutInfo) == 0){
            throw new IllegalStateException("insert error");
        }
        int n = -3;
        Stock stock = stockMapper.selectByPrimaryKey(stockInOutInfo.getStockName());
        if (stock != null){
            if (stockInOutInfo.getStockType() == 1){
                stock.setStockCount(stock.getStockCount() + stockInOutInfo.getStockCount());
                n = updateStock(stock);
                return n;
            }else{
                int count = stock.getStockCount() - stockInOutInfo.getStockCount();
                if (n >= 0){
                    stock.setStockCount(count);
                    n = updateStock(stock);
                    return n;
                }else {
                    throw new IllegalStateException("Inventory shortage");
                }
            }
        }
        return n;
    }
}

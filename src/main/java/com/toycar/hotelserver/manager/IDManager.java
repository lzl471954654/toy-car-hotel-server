package com.toycar.hotelserver.manager;

import com.toycar.hotelserver.pojo.*;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * IDManager 管理各种 ID 生成的类
 * 主要采用 sha1 摘要算法
 * 各个属性相加 再加盐的方式处理
 *
 * 系统时间 nano + Thread ID + toyCar
 *
 * */
public class IDManager {

    public static String generateRoomOrderId(RoomOrder roomOrder){
        String message = roomOrder.getUserAccount()
                + roomOrder.getRoomId()
                + roomOrder.getStart().toString()
                + roomOrder.getEnd().toString()
                + roomOrder.getOrderPrice()
                + System.nanoTime()
                + Thread.currentThread().getId()
                + "toyCar";

        return DigestUtils.sha1Hex(message);
    }

    public static String generateServiceOrderId(ServiceOrder serviceOrder){
        String message = serviceOrder.getUserAccount()
                + serviceOrder.getRoomId()
                + serviceOrder.getServiceInfo()
                + serviceOrder.getServicePrice()
                + serviceOrder.getServiceType()
                + System.nanoTime()
                + Thread.currentThread().getId()
                + "toyCar";
        return DigestUtils.sha1Hex(message);
    }

    public static String generateIncomeId(Income income){
        String message = income.getOrderType()
                + income.getIncomePrice()
                + income.getIncomeDate().toString()
                + System.nanoTime()
                + Thread.currentThread().getId()
                + "toyCar";
        return DigestUtils.sha1Hex(message);
    }

    public static String generateExpId(Expenditure expenditure){
        String message = expenditure.getExpType()
                + expenditure.getExpPrice()
                + expenditure.getExpDate().toString()
                + System.nanoTime()
                + Thread.currentThread().getId()
                + "toyCar";
        return DigestUtils.sha1Hex(message);
    }

    public static String generateStockId(StockInOutInfo stockInOutInfo){
        String message = stockInOutInfo.getStockName()
                + stockInOutInfo.getStockCount()
                + stockInOutInfo.getStockDate().toString()
                + stockInOutInfo.getStockType()
                + System.nanoTime()
                + Thread.currentThread().getId()
                + "toyCar";
        return DigestUtils.sha1Hex(message);
    }
}

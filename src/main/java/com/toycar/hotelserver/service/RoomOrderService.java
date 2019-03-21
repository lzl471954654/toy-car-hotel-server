package com.toycar.hotelserver.service;

import com.toycar.hotelserver.manager.IDManager;
import com.toycar.hotelserver.manager.RoomManager;
import com.toycar.hotelserver.mapper.RoomOrderMapper;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class RoomOrderService {

    @Autowired(required = false)
    private RoomOrderMapper mapper;

    public RoomOrder findRoomOrderById(RoomOrder roomOrder){
        return mapper.selectByPrimaryKey(roomOrder.getOrderId());
    }

    public List<RoomOrder> findAll(){
        return mapper.selectAll();
    }

    public int updateOrder(RoomOrder roomOrder){
        Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
        int code;
        String orderId = roomOrder.getOrderId();
        String roomId = roomOrder.getRoomId();
        int count;
        if (RoomManager.lockRoom(roomId)){
            count = mapper.deleteByPrimaryKey(orderId);
            if (count == 1){
                count = mapper.checkStartTimeAndEndTimeContainsOrder(roomOrder).size();
                if (count == 0){
                    code = mapper.insert(roomOrder);
                }else {
                    // 订单日期冲突
                    code = -1;
                    TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);
                }
            }else {
                //订单不存在
                code = -2;
            }
        }else {
            code = -3;
        }
        TransactionAspectSupport.currentTransactionStatus().releaseSavepoint(savePoint);
        return code;
    }

    public int deleteRoomOrderByOrderId(RoomOrder roomOrder){
        return mapper.deleteByPrimaryKey(roomOrder.getOrderId());
    }

    public String addRoomOrder(RoomOrder roomOrder){
        int code;
        if (RoomManager.lockRoom(roomOrder.getRoomId())){
            int count = mapper.checkStartTimeAndEndTimeContainsOrder(roomOrder).size();
            if (count == 0){
                roomOrder.setOrderId(IDManager.generateRoomOrderId(roomOrder));
                code = mapper.insert(roomOrder);
            }else {
                //代表这个时间区间内 这个房间有部分时间被占用
                code = -1;
            }
            RoomManager.releaseRoom(roomOrder.getRoomId());
        }else {
            //有其他人操作
            code = -3;
        }

        return JSONUtil.generateJsonObjectWithCodeAndObj(code,roomOrder).toString();
    }



}

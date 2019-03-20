package com.toycar.hotelserver.service;

import com.toycar.hotelserver.manager.IDManager;
import com.toycar.hotelserver.manager.RoomManager;
import com.toycar.hotelserver.mapper.RoomOrderMapper;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.util.JSONUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomOrderService {

    @Autowired(required = false)
    private RoomOrderMapper mapper;

    public int updateOrder(RoomOrder roomOrder){

        return 0;
    }

    public int deleteRoomOrderByOrderId(RoomOrder roomOrder){
        return mapper.deleteByPrimaryKey(roomOrder.getOrderId());
    }

    public String addRoomOrder(RoomOrder roomOrder){
        int code;
        if (RoomManager.lockRoom(roomOrder.getRoomId())){
            int count = mapper.checkStartTimeAndEndTimeContainsOrder(roomOrder);
            if (count == 0){
                roomOrder.setOrderId(IDManager.generateRoomOrderId(roomOrder));
                code = mapper.insert(roomOrder);
            }else {
                //代表这个时间区间内 这个房间有部分时间被占用
                code = -1;
            }
            RoomManager.releaseRoom(roomOrder.getRoomId());
        }else {
            code = -2;
        }

        return JSONUtil.generateJsonObjectWithCodeAndObj(code,roomOrder).toString();
    }



}

package com.toycar.hotelserver.service;

import com.toycar.hotelserver.mapper.CommentsMapper;
import com.toycar.hotelserver.mapper.OrderTypeMapper;
import com.toycar.hotelserver.mapper.RoomOrderMapper;
import com.toycar.hotelserver.pojo.Comments;
import com.toycar.hotelserver.pojo.RoomOrder;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CommentsService {
    @Autowired(required = false)
    CommentsMapper commentsMapper ;

    @Autowired(required = false)
    RoomOrderMapper roomOrderMapper ;

    public String findAll(){
        List<Comments> commentsList = commentsMapper.selectAll();
        int n = 0;
        if (commentsList == null){
            n = -1;
        }else {
            n = 1;
        }
        return JSONUtil.generateJsonObjectWithCodeAndObj(n,commentsList).toString();
    }

    @Transactional
    public int add(Comments comments){
        int n = 0;
        RoomOrder roomOrder = roomOrderMapper.selectByPrimaryKey(comments.getOrderId());
        if(roomOrder != null){
            String str = "User :" + roomOrder.getUserAccount() +"&"+ comments.getText();
            comments.setText(str);
            n = commentsMapper.insert(comments);
            return n;
        }else {
            n = -1;
            return n;
        }
    }

    public int delete(String orderId){
        int n = commentsMapper.deleteByPrimaryKey(orderId);
        if (n == 0){
            n = -1;
        }
        return n;
    }

}

package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Comments;
import com.toycar.hotelserver.service.CommentsService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {
    @Autowired(required = false)
    CommentsService commentsService;

    @RequestMapping("/hotel/comments/findAll")
    public String findAll(){
        return commentsService.findAll();
    }

    @RequestMapping("/hotel/comments/add")
    public String add(String orderId,String text){
        Comments comments = new Comments();
        comments.setText(text);
        comments.setOrderId(orderId);
        int code = commentsService.add(comments);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,comments).toString();
    }

    @RequestMapping("/hotel/staff/comments/delete")
    public String delete(String orderId){
        int n = commentsService.delete(orderId);
        return JSONUtil.generateJsonObjectWithCodeAndObj(n,null).toString();
    }
}

package com.toycar.hotelserver.exception;

import com.google.gson.JsonObject;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public void handleAll(HttpServletResponse response,Exception e) throws IOException {
        JsonObject object = JSONUtil.generateJsonObjectWithCodeAndObj(-5,null);
        object.addProperty("message",e.getMessage());
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().println(object.toString());
    }
}

package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.ServiceOrder;
import com.toycar.hotelserver.service.ServiceOrderService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;


    @RequestMapping("/hotel/serviceOrder/add")
    public String addServiceOrder(ServiceOrder serviceOrder){
        int code = serviceOrderService.addServiceOrder(serviceOrder);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,code == 1 ? serviceOrder : null).toString();
    }

    @RequestMapping("/hotel/staff/serviceOrder/findAll")
    public String findAll(){
        List<ServiceOrder> list = serviceOrderService.findAll();
        return JSONUtil.generateJsonObjectWithCodeAndObj(list.size() > 0 ? 1 : 0,list).toString();
    }

    @RequestMapping("/hotel/staff/serviceOrder/findByOrderId")
    public String findById(ServiceOrder serviceOrder){
        ServiceOrder serviceOrder2 = serviceOrderService.findByOrderId(serviceOrder);
        return JSONUtil.generateJsonObjectWithCodeAndObj(serviceOrder2 == null ? 0 : 1,serviceOrder2).toString();
    }

    @RequestMapping("/hotel/serviceOrder/update")
    public String updateOrder(ServiceOrder serviceOrder){
        int code = serviceOrderService.updateServiceOrder(serviceOrder);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,code == 1 ? serviceOrder : null).toString();
    }

    @RequestMapping("/hotel/serviceOrder/delete")
    public String deleteOrder(ServiceOrder serviceOrder){
        int code = serviceOrderService.deleteServiceOrder(serviceOrder);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,code == 1 ? serviceOrder : null).toString();
    }




}

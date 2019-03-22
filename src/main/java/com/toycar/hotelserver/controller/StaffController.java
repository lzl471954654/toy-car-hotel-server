package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Staff;
import com.toycar.hotelserver.service.StaffService;
import com.toycar.hotelserver.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("/hotel/staff/findAll")
    public String findAll(){
        List<Staff> list = staffService.findAll();
        return JSONUtil.generateJsonObjectWithCodeAndObj(list.size() > 0 ? 1 : 0 , list).toString();
    }

    @RequestMapping("/hotel/staff/findByStaffAccount")
    public String findByStaffAccount(Staff staff){
        Staff m = staffService.findByStaffAccount(staff);
        return JSONUtil.generateJsonObjectWithCodeAndObj(m == null ? 0 : 1,m).toString();
    }

    @RequestMapping("/hotel/staff/delete")
    public String deleteStaff(Staff staff){
        int code = staffService.deleteStaff(staff);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code,null).toString();
    }

    @RequestMapping("/hotel/staff/update")
    public String updateStaff(Staff staff){
        int code = staffService.updateStaff(staff);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code, code == 1 ? staff : null).toString();
    }

    @RequestMapping("/hotel/staff/add")
    public String addStaff(Staff staff){
        int code = staffService.addStaff(staff);
        return JSONUtil.generateJsonObjectWithCodeAndObj(code, code == 1 ? staff : null).toString();
    }
}

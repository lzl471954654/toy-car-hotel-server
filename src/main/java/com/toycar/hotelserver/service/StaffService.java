package com.toycar.hotelserver.service;


import com.toycar.hotelserver.mapper.StaffMapper;
import com.toycar.hotelserver.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class StaffService {

    @Autowired(required = false)
    private StaffMapper staffMapper;

    @Transactional
    public int updateStaff(Staff staff){
        Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
        int code = -1;
        try{
            int count = staffMapper.deleteByPrimaryKey(staff.getStaffAccount());
            if (count == 1){
                count = staffMapper.insert(staff);
                if (count == 1){
                    code = 1;
                }else {
                    code = -1;
                    TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);
                }
            }else {
                TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);
                code = -1;
            }
        }finally {
            TransactionAspectSupport.currentTransactionStatus().releaseSavepoint(savePoint);
        }
        return code;
    }

    public int addStaff(Staff staff){
        return staffMapper.insert(staff);
    }

    public int deleteStaff(Staff staff){
        return staffMapper.deleteByPrimaryKey(staff.getStaffAccount());
    }

    public List<Staff> findAll(){
        return staffMapper.selectAll();
    }

    public Staff findByStaffAccount(Staff staff){
        return staffMapper.selectByPrimaryKey(staff.getStaffAccount());
    }


}

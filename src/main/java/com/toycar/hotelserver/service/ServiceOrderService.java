package com.toycar.hotelserver.service;

import com.toycar.hotelserver.manager.IDManager;
import com.toycar.hotelserver.mapper.ExpenditureMapper;
import com.toycar.hotelserver.mapper.IncomeMapper;
import com.toycar.hotelserver.mapper.ServiceOrderMapper;
import com.toycar.hotelserver.pojo.Income;
import com.toycar.hotelserver.pojo.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired(required = false)
    private ServiceOrderMapper mapper;

    @Autowired(required = false)
    private IncomeMapper incomeMapper;

    @Autowired(required = false)
    private ExpenditureMapper expenditureMapper;


    @Transactional(rollbackFor = Exception.class)
    public int addServiceOrder(ServiceOrder serviceOrder){
        serviceOrder.setServiceId(IDManager.generateServiceOrderId(serviceOrder));
        int count = mapper.insert(serviceOrder);
        if (count == 1){
            Income income = new Income();
            income.setIncomeDate(new Date(System.currentTimeMillis()));
            income.setIncomePrice(serviceOrder.getServicePrice());
            income.setOrderId(serviceOrder.getServiceId());
            income.setOrderType(2);
            count = incomeMapper.insert(income);
            if (count != 1)
                throw new IllegalStateException("insert service order success , but insert income failed.\tIncome:"+income);
        }
        return count == 1 ? 1 : 0;
    }


    @Transactional(rollbackFor = Exception.class)
    public int deleteServiceOrder(ServiceOrder serviceOrder){
        int count = mapper.deleteByPrimaryKey(serviceOrder.getServiceId());
        if (count == 1){
            Income income = incomeMapper.selectByPrimaryKey(serviceOrder.getServiceId());
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            if (date.getTime() - income.getIncomeDate().getTime() > 0){
                count = incomeMapper.deleteByPrimaryKey(income.getOrderId());
            }
            if (count != 1)
                throw new IllegalStateException("deleteServiceOrder");
        }
        return count == 1 ? 1 : 0;
    }

    public int updateServiceOrder(ServiceOrder serviceOrder){
        return mapper.updateByPrimaryKeySelective(serviceOrder);
    }

    public List<ServiceOrder> findAll(){
        return mapper.selectAll();
    }

    public ServiceOrder findByOrderId(ServiceOrder serviceOrder){
        return mapper.selectByPrimaryKey(serviceOrder.getServiceId());
    }




}

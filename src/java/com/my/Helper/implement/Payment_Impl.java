
package com.my.Helper.implement;

import com.my.Helper.dao.PaymentDao;
import com.my.Helper.interfaces.Payment_Iface;
import com.my.Models.ModelPayment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TP32447
 */
@Service(value="Payment_Impl")
@Transactional(readOnly=true)
public class Payment_Impl implements Payment_Iface{

    
    @Autowired 
    private PaymentDao paymentDao;
    
    @Transactional(readOnly=false)
    @Override
    public ModelPayment insert(ModelPayment data) {
        return paymentDao.save(data);
    }

    @Override
    public ModelPayment update(Integer key, ModelPayment data) {
    
        return data;
    }

    @Override
    public ModelPayment detail(Integer key) {
    
        ModelPayment data = new ModelPayment();
        return data;
    }

    @Override
    public List<ModelPayment> select(Integer key) {
        List<ModelPayment> data = new ArrayList();
        return data;
    }

    @Override
    public List<ModelPayment> find(HashMap filter, Integer offset, Integer limit, String OrderField, String Order) {
        List<ModelPayment> data = new ArrayList();
        return data;
    }
    
}

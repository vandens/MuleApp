
package com.my.Helper.interfaces;

import com.my.Models.ModelPayment;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TP32447
 */

public interface Payment_Iface {
    
    /**
     *
     * @param data
     * @return
     */
    ModelPayment insert (ModelPayment data);
    ModelPayment update (Integer key, ModelPayment data);
    ModelPayment detail (Integer key);
    List<ModelPayment> select (Integer key);
    List<ModelPayment> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

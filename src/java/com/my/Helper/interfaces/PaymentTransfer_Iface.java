
package com.my.Helper.interfaces;

import com.my.Models.ModelPaymentTransfer;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TP32447
 */
public interface PaymentTransfer_Iface {
    
    ModelPaymentTransfer insert (ModelPaymentTransfer data);
    ModelPaymentTransfer update (Integer key, ModelPaymentTransfer data);
    ModelPaymentTransfer detail (Integer key);
    List<ModelPaymentTransfer> select (Integer key);
    List<ModelPaymentTransfer> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

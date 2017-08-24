
package com.my.Helper.interfaces;

import com.my.Objects.PaymentTransferObject;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vandens mc Maddens
 */
public interface PaymentTransfer_Iface {
    
    PaymentTransferObject insert (PaymentTransferObject data);
    PaymentTransferObject update (Integer key, PaymentTransferObject data);
    PaymentTransferObject detail (Integer key);
    List<PaymentTransferObject> select (Integer key);
    List<PaymentTransferObject> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

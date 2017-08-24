
package com.my.Helper.interfaces;

import com.my.Models.PaymentModel;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vandens mc Maddens
 */

public interface Payment_Iface {
    
    /**
     *
     * @param data
     * @return
     */
    PaymentModel insert (PaymentModel data);
    PaymentModel update (Integer key, PaymentModel data);
    PaymentModel detail (Integer key);
    List<PaymentModel> select (Integer key);
    List<PaymentModel> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

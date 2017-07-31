
package com.my.Helper.interfaces;

import com.my.Models.ModelUser;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TP32447
 */
public interface User_Iface {
    ModelUser insert (ModelUser data);
    ModelUser update (Integer key, ModelUser data);
    ModelUser detail (Integer key);
    List<ModelUser> select (Integer key);
    List<ModelUser> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

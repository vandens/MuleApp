
package com.my.Helper.interfaces;

import com.my.Models.ModelInterfaceLog;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TP32447
 */
public interface InterfaceLog_Iface {
    
    ModelInterfaceLog insert (ModelInterfaceLog data);
    ModelInterfaceLog update (Integer key, ModelInterfaceLog data);
    ModelInterfaceLog detail (Integer key);
    List<ModelInterfaceLog> select (Integer key);
    List<ModelInterfaceLog> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

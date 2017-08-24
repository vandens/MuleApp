
package com.my.Helper.interfaces;

import com.my.Models.InterfaceLogModel;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vandens mc Maddens
 */
public interface InterfaceLog_Iface {
    
    InterfaceLogModel insert (InterfaceLogModel data);
    InterfaceLogModel update (Integer key, InterfaceLogModel data);
    InterfaceLogModel detail (Integer key);
    List<InterfaceLogModel> select (Integer key);
    List<InterfaceLogModel> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

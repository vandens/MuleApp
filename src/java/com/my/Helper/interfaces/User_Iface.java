
package com.my.Helper.interfaces;

import com.my.Objects.UserObject;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vandens mc Maddens
 */
public interface User_Iface {
    UserObject insert (UserObject data);
    UserObject update (Integer key, UserObject data);
    UserObject detail (Integer key);
    List<UserObject> select (Integer key);
    List<UserObject> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    
}

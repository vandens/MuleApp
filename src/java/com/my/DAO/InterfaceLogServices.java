
package com.my.DAO;

import com.my.Objects.InterfaceLogObject;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Vandens mc Maddens
 */
public interface InterfaceLogServices {
    public void setDataSource(DataSource ds);
    public void Insert(InterfaceLogObject interfacelog);
    public InterfaceLogObject Detail(String user_id);
    public List<InterfaceLogObject> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
}

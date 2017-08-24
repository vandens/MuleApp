
package com.my.DAO;

import com.my.Objects.UserObject;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Vandens mc Maddens
 */
public interface UserDAO {
    public void setDataSource(DataSource ds);
    public void Insert(String user_id, String user_fullname, String user_password, String user_status, String user_islogin);
    public UserObject Detail(String user_id);
    public List<UserObject> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
}

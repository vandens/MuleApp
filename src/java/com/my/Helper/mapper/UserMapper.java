
package com.my.Helper.mapper;

import com.my.Objects.UserObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Vandens mc Maddens
 */
public class UserMapper implements RowMapper<UserObject>{

    @Override
    public UserObject mapRow(ResultSet rs, int i) throws SQLException {
        UserObject user = new UserObject();
        user.set_user_id(rs.getString("user_id"));
        user.set_user_fullname(rs.getString("user_fullname"));
        user.set_user_password(rs.getString("user_password"));
        user.set_user_status(rs.getInt("user_status"));
        user.set_user_islogin(rs.getInt("user_islogin"));
        return user;
    }
    
}

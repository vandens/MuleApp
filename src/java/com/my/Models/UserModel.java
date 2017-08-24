
package com.my.Models;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.my.DAO.UserDAO;
import com.my.Objects.UserObject;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vandens mc Maddens
 */
public class UserModel implements UserDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbc;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbc = new JdbcTemplate(dataSource);
    }

    
    public void Insert(String user_id, String user_fullname, String user_password , String user_status , String user_islogin ) {       
        try{
            String SQL = "INSERT INTO M_USER VALUES (?,?,?,?,?)";
            jdbc.update( SQL, user_id, user_fullname, user_password, user_status, user_islogin);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }   
    }

    @Override
    public UserObject Detail(String user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserObject> find(HashMap filter, Integer offset, Integer limit, String OrderField, String Order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

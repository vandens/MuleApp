
package com.my.Models;

import com.my.DAO.InterfaceLogDAO;
import static com.my.Helper.General.dateToString;
import com.my.Objects.InterfaceLogObject;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Vandens mc Maddens
 */
public class InterfaceLogModel implements InterfaceLogDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbc;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void Insert(InterfaceLogObject interfacelog) {
      
            String UID              = interfacelog.get_uid();
            String CHANNEL_ID       = interfacelog.get_channel_id();
            String LOG_DATE         = dateToString(interfacelog.get_log_date(),"datetime");
            String PAY_NUMBER       = interfacelog.get_pay_number();
            String FEATURE_ID       = interfacelog.get_feature_id();
            String FUNCTION_NAME    = interfacelog.get_function_name();
            String RAW_REQUEST      = interfacelog.get_raw_request();
            String RAW_RESPONSE     = interfacelog.get_raw_response();
            String ERROR_CODE       = interfacelog.get_error_code();
            String ERROR_DESC       = interfacelog.get_error_desc();
            String SEND_TIME        = interfacelog.get_send_time();
            String RESPONSE_TIME    = interfacelog.get_response_time();                     
            String SQL = "INSERT INTO T_INTERFACE_LOG (UID, CHANNEL_ID, LOG_DATE, PAY_NUMBER, FEATURE_ID, FUNCTION_NAME, RAW_REQUEST, RAW_RESPONSE, ERROR_CODE, ERROR_DESC, SEND_TIME, RESPONSE_TIME)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbc.update( SQL, UID, CHANNEL_ID, LOG_DATE, PAY_NUMBER, FEATURE_ID, FUNCTION_NAME, RAW_REQUEST, RAW_RESPONSE, ERROR_CODE, ERROR_DESC, SEND_TIME, RESPONSE_TIME);
                
    }

    @Override
    public InterfaceLogObject Detail(String user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InterfaceLogObject> find(HashMap filter, Integer offset, Integer limit, String OrderField, String Order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

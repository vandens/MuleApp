
package com.my.main;

import static com.my.Helper.General.ObjectLoger;
import static com.my.Helper.General.dateToString;
import static com.my.Helper.MarshallUnMarshall.UnMarshalling;
import com.my.Models.InterfaceLogModel;
import com.my.Models.UserModel;
import com.my.Objects.InterfaceLogObject;
import com.my.Service.CitiCargo.CitiCargo;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author Vandens mc Maddens
 */
public class MainApp {
    
    
    
    
    
    public static void main(String[] args) throws Exception{
        
        
        Date send_time  = new Date();
        /*
        ApplicationContext context = new ClassPathXmlApplicationContext("configContext.xml");
        UserModel userModel     = (UserModel)context.getBean("UserModel");
        InterfaceLogModel ilm   = (InterfaceLogModel)context.getBean("InterfaceLogModel");
        */
        CitiCargo citiCargo     = new CitiCargo();
        try {
            citiCargo.InquiryClient("LPX-0001");
            String _serverRawRequest       = citiCargo.getrawRequest();
            String _serverRawResponse      = citiCargo.getrawResponse();
            
            CitiCargo_InquiryClientResponse x = (CitiCargo_InquiryClientResponse) UnMarshalling(_serverRawResponse, "com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse");
                        
            InterfaceLogObject ilo         = new InterfaceLogObject();
            ilo.set_uid("5DBEC874-7DDC-4EF9-A49D-47CF448AB5BE");
            ilo.set_log_date(send_time);
            ilo.set_feature_id("CITICARGO");
            ilo.set_raw_request(_serverRawRequest);
            ilo.set_raw_response(_serverRawResponse);
            ilo.set_function_name("InquiryClient");
            ilo.set_send_time(send_time);
            ilo.set_response_time(new Date());
            ilo.set_error_code("00");
            ilo.set_error_desc("");
            ilo.set_pay_number("");
            
            System.out.println(ObjectLoger(citiCargo));
            
            System.exit(0);
            //ilm.Insert(ilo);
            
            try {
                InterfaceLogObject oli = (InterfaceLogObject) ilo.clone();
                System.out.println(oli.get_feature_id());
                oli.set_feature_id("LIONCARGO");
                System.out.println(oli.get_feature_id());
                
                

            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SOAPException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

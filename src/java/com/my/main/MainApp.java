
package com.my.main;

import com.my.Helper.interfaces.Payment_Iface;
import com.my.Helper.interfaces.SyncLog_Iface;
import com.my.Models.ModelPayment;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author TP32447
 */
public class MainApp {
    
    private static Payment_Iface payment_iface;
    private static SyncLog_Iface syncLog_iface;
    
    public static Payment_Iface getPayment(){
        return payment_iface;
    }
    public static SyncLog_Iface getSyncLog(){
        return syncLog_iface;
    }
    
    public static void main(String[] args){
        
        try{
                    
            ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("classpath:configContext.xml");
           // payment_iface               = (Payment_Iface) context.getBean(Payment_Iface.class);
            syncLog_iface               = (SyncLog_Iface) context.getBean(SyncLog_Iface.class);
           
        }catch(Exception ex){
            System.out.println("Excp : "+ex.toString());
            System.exit(0);
        }
                
    }
}

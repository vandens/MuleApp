
package com.my.Objects;

import static com.my.Helper.General.ObjectLoger;
import com.my.Helper.GlobalProperty;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Vandens mc Maddens
 */
public class PartnerObject {
    
    public static GlobalProperty gp = GlobalProperty.getGlobalProp("./config/partners.properties");
    
    private String PartnerID;
    private String PartnerName;
    private String WsdlPath;
    private int WaitTimeout;
    private int SoTimeout;
    private String DecryptCheck;
    private String EncryptIV;
    private String EncryptKey;
    
    
    public PartnerObject(){}
    
    public PartnerObject(String partnerID){
        this.PartnerID = partnerID;
        this.PartnerName = gp.getPropValue(partnerID, "partner_name");
    }
    
    
    public static void main(String[] args){        
        ApplicationContext context  = new ClassPathXmlApplicationContext("configContext.xml");
        PartnerObject partner = (PartnerObject) context.getBean("PartnerConfigurator");
        
    }
    
}

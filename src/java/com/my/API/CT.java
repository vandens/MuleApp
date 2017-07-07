
package com.my.API;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement//(namespace="http://localhost:1231/API/CTService")
@WebService(name="CT")//, targetNamespace="http://localhost:1231/API/CTService")
public class CT {
    
      
    //public static Logging write             = new Logging("CT");
    private Logger log = Logger.getLogger(CT.class.getName()); 
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Logon")//, action="http://10.225.16.55:8080/API/CTService/Inquiry")
    @XmlElement(name="Signature")
    public String Inquiry(@WebParam(name="customer_id") String customer_id){
        
        return customer_id+" Mantabbss ";
    }
    
   
}



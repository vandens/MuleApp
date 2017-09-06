/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.Service;

import com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.ws.client.*;

/**
 *
 * @author TP32447
 */
public class WSClient {
    
    //private SourceExtractor ratingResponseExtractor = new RatingResponseExtractor();
    
    public static void main(String[] args){        
        
        ApplicationContext context  = new ClassPathXmlApplicationContext("serviceContext.xml");
        WebServiceTemplate ws       = (WebServiceTemplate)context.getBean("citiCargo_wsTemplate");
        
        try{
            
            CitiCargo_InquiryClientRequestData ct = new CitiCargo_InquiryClientRequestData();
            ct.customer_id      = "LPX-0001";
            Object x            = ws.marshalSendAndReceive(ct);
            
            StringResult request = new StringResult();
            StringResult response = new StringResult();
            
            ws.getMarshaller().marshal(ct, request);            
            ws.getMarshaller().marshal(x,response);
            
            System.out.println(request.toString());
            System.out.println(response.toString());
                 
        }catch(WebServiceIOException | IOException ex){
            System.out.println("WebServiceIOException : "+ex.getMessage()); 
        } catch (XmlMappingException ex) {
            System.out.println("XmlMappingException : "+ex.getMessage()); 
        }
    }

}

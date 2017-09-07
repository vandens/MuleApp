/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.Service;

import com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.ws.client.*;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 *
 * @author TP32447
 */
public class WSClient {
    
    //private SourceExtractor ratingResponseExtractor = new RatingResponseExtractor();
    
    public static void main(String[] args){        
        
        ApplicationContext context  = new ClassPathXmlApplicationContext("serviceContext.xml");
        WebServiceTemplate ws       = (WebServiceTemplate)context.getBean("wsClientTemplate");
        HttpComponentsMessageSender xx = (HttpComponentsMessageSender) context.getBean("msgSender");
        
        try{
            
            CitiCargo_InquiryClientRequestData ct = new CitiCargo_InquiryClientRequestData();
            ct.customer_id      = "LPX-0001";
            CitiCargo_InquiryClientResponse x            = (CitiCargo_InquiryClientResponse) ws.marshalSendAndReceive(ct);
            
            StringResult request = new StringResult();
            StringResult response = new StringResult();
            
            ws.getMarshaller().marshal(ct, request);            
            ws.getMarshaller().marshal(x,response);
            
            System.out.println(request.toString());
            
            String s = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><ns2:InquiryClientResponse xmlns:ns2=\"http://localhost:8080/simulator/CargoService\" xmlns:ns3=\"http://localhost:8080/simulator/KSService/CargoReportObj\"><InquiryClientResult><anyType>LPX-0001</anyType><anyType>Harapan Travel</anyType><anyType>01</anyType><anyType>Exist</anyType></InquiryClientResult></ns2:InquiryClientResponse></S:Body></S:Envelope>";
            
            StreamSource res = new StreamSource(new StringReader(s));
            
            StreamResult ret = new StreamResult(System.out);
            ws.getMarshaller().marshal(res, ret);
            
            
            System.out.println(request.toString());
            System.out.println(response.toString());
                 
        }catch(WebServiceIOException | IOException ex){
            System.out.println("WebServiceIOException : "+ex.getMessage()); 
        } catch (XmlMappingException ex) {
            System.out.println("XmlMappingException : "+ex.getMessage()); 
        }
    }

}


package com.my.API;

import com.my.Helper.General.MessageID;
import static com.my.Helper.General.dateToString;
import com.my.Helper.serviceObject.*;
import com.my.Models.InterfaceLogModel;
import com.my.main.InquiryClientRequestHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlElement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(name="PartnerServices", targetNamespace="http://www.my.co.id/PartnerServices")
public class Partner {
    
    private static final Logger log = Logger.getLogger(Partner.class.getName()); 
    public static HashMap<String, MessageID> messageID = new HashMap<>();
    public static InterfaceLogModel interfaceLog;
    
    public Partner(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("configContext.xml");
        interfaceLog                = (InterfaceLogModel)context.getBean("InterfaceLogModel");
    }
    
    /**
     * Web service operation
     * @param RequestData
     * @return InquiryClientResponseData
     */
    @WebMethod(operationName="InquiryClient", action="http://www.my.co.id/PartnerServices/InquiryClient")
    @XmlElement(name="InquiryClientResponse")
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE, use = Use.LITERAL)
    public InquiryClientResponse InquiryClient(@WebParam(name="InquiryClient") InquiryClientRequest RequestData){
        
        //if(messageID.get(RequestData.channelHeader.messageID) != null){
        //    Logger.getLogger(Partner.class.getName()).log(Level.SEVERE, null, "Invalid MessageID : "+RequestData.channelHeader.messageID);
        //}else{
            
            InquiryClientRequestHandler request = new InquiryClientRequestHandler();
            messageID.put(RequestData.channelHeader.messageID, new MessageID(RequestData.channelHeader.messageID));
            request.InquiryClientService(RequestData);
            return request.getRespond();
            
        //}
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InquiryPayment")
    public String InquiryPayment() {
        //TODO write your implementation code here:
        return null;
    }
        
    /**
     * Web service operation
     */
    @WebMethod(operationName = "InquiryStatus")
    public String InquiryStatus() {
        //TODO write your implementation code here:
        return null;
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "PaymentSync")
    public String PaymentSync() {
        //TODO write your implementation code here:
        return null;
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "PaymentRevers")
    public String PaymentRevers() {
        //TODO write your implementation code here:
        return null;
    }
    
    
    public static void main(String[] args){
            ChannelHeader ch    = new ChannelHeader();
            ch.channelID = "asdf";
            ch.messageID = "fdadf";
            ch.reference = "234567";
            ch.transactiondate  = dateToString(new Date(),"ymd");
            ch.transactiontime  = dateToString(new Date(),"HHmmss");
            
            InquiryClientRequestData ic = new InquiryClientRequestData();            
            ic.partnerID        = "CITICARGO";
            ic.clientID         = "IDX-0109";
            
            InquiryClientRequest icr = new InquiryClientRequest();
            icr.channelHeader   = ch;
            icr.inquiryClientRequestData = ic;
            
            InquiryClientRequestHandler m = new InquiryClientRequestHandler();
            
            
            m.InquiryClientService(icr);
            InquiryClientResponse x = m.getRespond();
            System.out.println(x.inquiryClientResponseData.toString());
    }
}


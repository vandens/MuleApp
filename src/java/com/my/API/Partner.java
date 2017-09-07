
package com.my.API;

import com.my.Helper.General.MessageID;
import static com.my.Helper.General.dateToString;
import com.my.Helper.serviceObject.*;
import com.my.Models.InterfaceLogModel;
import com.my.main.InquiryClientRequestHandler;
import com.my.main.InquiryClientRequestHandlers;
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
     * @return InquiryAgentResponseData
     */
    @WebMethod(operationName="InquiryAgent", action="http://www.my.co.id/PartnerServices/InquiryClient")
    @XmlElement(name="InquiryClientResponse")
    @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE, use = Use.LITERAL)
    public InquiryAgentResponse InquiryAgent(@WebParam(name="InquiryAgent") InquiryAgentRequest RequestData){
        InquiryClientRequestHandlers request = new InquiryClientRequestHandlers();
        messageID.put(RequestData.channelHeader.messageID, new MessageID(RequestData.channelHeader.messageID));
        request.InquiryClientService(RequestData);
        return request.getRespond();
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
        Partner p = new Partner();
            ChannelHeader ch    = new ChannelHeader();
            ch.channelID = "asdf";
            ch.messageID = "fdadf";
            ch.reference = "234567";
            ch.transactiondate  = dateToString(new Date(),"ymd");
            ch.transactiontime  = dateToString(new Date(),"HHmmss");
            
            InquiryAgentRequestData ic = new InquiryAgentRequestData();            
            ic.partnerID        = "CITICARGO";
            ic.clientID         = "LPX-0001";
            
            InquiryAgentRequest icr = new InquiryAgentRequest();
            icr.channelHeader   = ch;
            icr.inquiryClientRequestData = ic;
            
            InquiryClientRequestHandlers m = new InquiryClientRequestHandlers();
            
            
            m.InquiryClientService(icr);
            InquiryAgentResponse x = m.getRespond();
            System.out.println(x.inquiryAgentResponseData.toString());
    }
}


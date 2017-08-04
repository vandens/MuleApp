
package com.my.API;

import com.my.Helper.serviceObject.InquiryClientRequest;
import com.my.Helper.serviceObject.InquiryClientResponse;
import com.my.Helper.General.MessageID;
import com.my.main.InquiryClientRequestHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.parsers.ParserConfigurationException;

@WebService(name="PartnerServices", targetNamespace="http://www.my.co.id/PartnerServices")
public class Partner {
    
    private static final Logger log = Logger.getLogger(Partner.class.getName()); 
    public static HashMap<String, MessageID> messageID = new HashMap<String, MessageID>();
    
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
            return request._inquiryClientResponse;
            
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
    @WebMethod(operationName = "SyncPaymentStatus")
    public String InquiryStatus() {
        //TODO write your implementation code here:
        return null;
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "SyncPayment")
    public String PaymentSync() {
        //TODO write your implementation code here:
        return null;
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "PaymentReversal")
    public String PaymentRevers() {
        //TODO write your implementation code here:
        return null;
    }
}


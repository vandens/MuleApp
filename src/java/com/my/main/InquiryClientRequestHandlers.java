
package com.my.main;

import com.my.API.Partner;
import static com.my.API.Partner.interfaceLog;
import com.my.Helper.serviceObject.InquiryAgentRequest;
import com.my.Helper.serviceObject.InquiryAgentRequestData;
import com.my.Helper.serviceObject.InquiryAgentResponse;
import com.my.Helper.serviceObject.InquiryAgentResponseData;
import com.my.Helper.serviceObject.ChannelHeader;
import com.my.Helper.serviceObject.GlobalResponseDetail;
import static com.my.Helper.General.*;
import static com.my.Helper.MarshallUnMarshall.Marshalling;
import static com.my.Helper.MarshallUnMarshall.UnMarshalling;
import com.my.Objects.InterfaceLogObject;
import com.my.Service.CitiCargo.CitiCargo;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;


public class InquiryClientRequestHandlers {
    private String GlobalRespCode = "";
    private String DetailRespCode = "";
    private String DetailRespDesc = "";
    private String ClientID, ClientName, ClientStatus, ClientDesc = "";
    
    //from client / Channel
    public StringResult _clientRawRequest    = new StringResult();
    public StringResult _clientRawResponse   = new StringResult();
    
    //to each partners
    public StringResult _serverRawRequest    = new StringResult();
    public StringResult _serverRawResponse   = new StringResult();
    
    private InquiryAgentResponse _inquiryAgentResponse = new InquiryAgentResponse();
    
    private static final Logger log = Logger.getLogger(InquiryClientRequestHandler.class.getName());  
    
    public void InquiryClientService(InquiryAgentRequest RequestData){
        
        ApplicationContext context  = new ClassPathXmlApplicationContext("serviceContext.xml");
        WebServiceTemplate ws       = (WebServiceTemplate)context.getBean("wsClientTemplate");
        
        InquiryAgentResponseData icrd  = new InquiryAgentResponseData();
        GlobalResponseDetail grd        = new GlobalResponseDetail();
        InterfaceLogObject   clientMsg  = new InterfaceLogObject();
        InterfaceLogObject   serverMsg  = null;
        
        try {
            ws.getMarshaller().marshal(RequestData, _clientRawRequest);
            
        } catch (IOException | XmlMappingException ex) {
            DetailRespCode               = "-1";
            DetailRespDesc               = ex.getMessage();
        } 
        
        try { 
                   
                //create object for client side message logging
                clientMsg.set_auto(0);
                clientMsg.set_uid(RequestData.channelHeader.messageID);
                clientMsg.set_channel_id(RequestData.channelHeader.channelID);
                clientMsg.set_feature_id(RequestData.inquiryClientRequestData.partnerID);
                clientMsg.set_function_name("InquiryClientService (Client)");
                clientMsg.set_log_date(new Date());
                clientMsg.set_send_time(new Date());
                clientMsg.set_raw_request(_clientRawRequest.toString());
            
                //if(RequestData.inquiryClientRequestData.partnerID.equalsIgnoreCase("CITICARGO")){
            
                try {                
                    //create object for server side message logging
                    serverMsg    = (InterfaceLogObject) clientMsg.clone();
                    serverMsg.set_raw_request(null);
                    
                } catch (CloneNotSupportedException ex) {
                    DetailRespCode               = "-1";
                    DetailRespDesc               = ex.getMessage();
                }
            
                serverMsg.set_function_name("InquiryClientService (Server)");
                serverMsg.set_send_time(new Date());
            
            if(DetailRespCode != null || !DetailRespCode.isEmpty()){
                
                //build message
                CitiCargo_InquiryClientRequestData inquiry    = new CitiCargo_InquiryClientRequestData();
                inquiry.customer_id                           = RequestData.inquiryClientRequestData.clientID;
        
                //send message
                CitiCargo_InquiryClientResponse inquiryResult = (CitiCargo_InquiryClientResponse) ws.marshalSendAndReceive(inquiry);
                               
                ws.getMarshaller().marshal(inquiry, _serverRawRequest);
                ws.getMarshaller().marshal(inquiryResult, _serverRawResponse);   
                
                //set response
                ClientID             = RequestData.inquiryClientRequestData.clientID;
                ClientName           = inquiryResult.InquiryClientResult.Respond[1];
                ClientStatus         = inquiryResult.InquiryClientResult.Respond[2];
                ClientDesc           = inquiryResult.InquiryClientResult.Respond[3];
                
                
                serverMsg.set_raw_request(_serverRawRequest.toString());
                serverMsg.set_raw_response(_serverRawResponse.toString());
                serverMsg.set_response_time(new Date());
                serverMsg.set_error_code(ClientStatus);
                serverMsg.set_error_desc(ClientDesc);
            //}
            
                DetailRespCode            = "00";
                DetailRespDesc            = "Success";
                icrd.clientID               = ClientID;
                icrd.clientName             = ClientName;
                icrd.clientDesc             = ClientDesc;
            
            }
            
        } catch (WebServiceIOException | IOException  ex) { 
            
            if(ex.getMessage().toLowerCase().indexOf("refused") != -1 || ex.getMessage().indexOf("404") != -1){                
                DetailRespCode               = "-1";
                DetailRespDesc               = ex.getMessage();                
            }else{                       
                DetailRespCode               = "99";
                DetailRespDesc               = "Exception";  
            }            
            log.warning(ObjectLoger(ex));
            
        }finally{
            
            try {
                
                grd.responseCode               = DetailRespCode;
                grd.responseDesc               = DetailRespDesc;
                _inquiryAgentResponse.responseCode                = DetailRespCode;
                _inquiryAgentResponse.responseDetail              = grd;
                _inquiryAgentResponse.inquiryAgentResponseData   = icrd;
                
                ws.getMarshaller().marshal(_inquiryAgentResponse, _clientRawResponse);
                
                clientMsg.set_raw_response(_clientRawResponse.toString());
                clientMsg.set_response_time(new Date());
                clientMsg.set_error_code(grd.responseCode);
                clientMsg.set_error_desc(grd.responseDesc);
                
                log.info(ObjectLoger(clientMsg));
                log.info(ObjectLoger(serverMsg));
                
                interfaceLog.Insert(clientMsg);
                if(serverMsg != null)
                    interfaceLog.Insert(serverMsg);
                
            } catch (IOException | XmlMappingException ex) {
                DetailRespCode               = "99";
                DetailRespDesc               = "Exception"; //ex.getMessage();  
                log.warning(ObjectLoger(ex));
            }

        }
    }
    
    
    public InquiryAgentResponse getRespond(){
        return _inquiryAgentResponse;
    }
    
    public static void main(String[] args){
            Partner par = new Partner();
            
            ChannelHeader ch    = new ChannelHeader();
            ch.channelID = "asdf";
            ch.messageID = "fdadf";
            ch.reference = "234567";
            ch.transactiondate  = dateToString(new Date(),"dmy");
            ch.transactiontime  = dateToString(new Date(),"HH:mm:ss");
            
            InquiryAgentRequestData ic = new InquiryAgentRequestData();            
            ic.partnerID        = "CITICARGO";
            ic.clientID         = "LPX-0001";
            
            InquiryAgentRequest icr = new InquiryAgentRequest();
            icr.channelHeader   = ch;
            icr.inquiryClientRequestData = ic;
            
            InquiryClientRequestHandlers m = new InquiryClientRequestHandlers();
            
            
            m.InquiryClientService(icr);
            
    }
    
}

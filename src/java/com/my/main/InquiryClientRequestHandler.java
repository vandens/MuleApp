
package com.my.main;

import static com.my.API.Partner.interfaceLog;
import com.my.Helper.serviceObject.InquiryClientRequest;
import com.my.Helper.serviceObject.InquiryClientRequestData;
import com.my.Helper.serviceObject.InquiryClientResponse;
import com.my.Helper.serviceObject.InquiryClientResponseData;
import com.my.Helper.serviceObject.ChannelHeader;
import com.my.Helper.serviceObject.GlobalResponseDetail;
import static com.my.Helper.General.*;
import static com.my.Helper.MarshallUnMarshall.Marshalling;
import static com.my.Helper.MarshallUnMarshall.UnMarshalling;
import com.my.Objects.InterfaceLogObject;
import com.my.Service.CitiCargo.CitiCargo;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;


public class InquiryClientRequestHandler {
    private String GlobalRespCode, DetailRespCode, DetailRespDesc = "";
    private String ClientID, ClientName, ClientStatus, ClientDesc = "";
    
    //from client / Channel
    public static String _clientRawRequest = null;
    public static String _clientRawResponse = null;
    
    //to each partners
    public static String _serverRawRequest = null;
    public static String _serverRawResponse = null;
    
    public InquiryClientResponse _inquiryClientResponse = new InquiryClientResponse();
    
    private static final Logger log = Logger.getLogger(InquiryClientRequestHandler.class.getName());  
    
    public void InquiryClientService(InquiryClientRequest RequestData){
        
        InquiryClientResponseData icrd  = new InquiryClientResponseData();
        GlobalResponseDetail grd        = new GlobalResponseDetail();
        InterfaceLogObject   clientMsg  = new InterfaceLogObject();
        InterfaceLogObject   serverMsg  = null;
        
        try {
            _clientRawRequest = Marshalling(RequestData,"com.my.Helper.serviceObject.InquiryClientRequest"); 
            
            //create object for client side message logging
            clientMsg.set_auto(0);
            clientMsg.set_uid(RequestData.channelHeader.messageID);
            clientMsg.set_channel_id(RequestData.channelHeader.channelID);
            clientMsg.set_feature_id(RequestData.inquiryClientRequestData.partnerID);
            clientMsg.set_function_name("InquiryClientService (Client)");
            clientMsg.set_log_date(new Date());
            clientMsg.set_send_time(new Date());
            clientMsg.set_raw_request(_clientRawRequest);
            
            
                       
            //if(RequestData.inquiryClientRequestData.partnerID.equalsIgnoreCase("CITICARGO")){
                
                //create object for server side message logging
                serverMsg    = (InterfaceLogObject) clientMsg.clone();
                serverMsg.set_function_name("InquiryClientService (Server)");
                serverMsg.set_send_time(new Date());
                
                
                CitiCargo citiCargo             = new CitiCargo();
                Date SendTime                   = new Date();
                citiCargo.InquiryClient(RequestData.inquiryClientRequestData.clientID);
                _serverRawRequest               = citiCargo.getrawRequest();
                _serverRawResponse              = citiCargo.getrawResponse();
                                
                CitiCargo_InquiryClientResponse x = (CitiCargo_InquiryClientResponse) UnMarshalling(_serverRawResponse, "com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse");
                
                //set response
                ClientID             = RequestData.inquiryClientRequestData.clientID;
                ClientName           = x.InquiryClientResult.Respond[1];
                ClientStatus         = x.InquiryClientResult.Respond[2];
                ClientDesc           = x.InquiryClientResult.Respond[3];
                
                
                serverMsg.set_raw_request(_serverRawRequest);
                serverMsg.set_raw_response(_serverRawResponse);
                serverMsg.set_response_time(new Date());
                serverMsg.set_error_code(ClientStatus);
                serverMsg.set_error_desc(ClientDesc);
            //}
            
            grd.responseCode            = "00";
            grd.responseDesc            = "Success";
            icrd.clientID               = ClientID;
            icrd.clientName             = ClientName;
            icrd.clientDesc             = ClientDesc;
            _inquiryClientResponse.responseCode                = "00";
            _inquiryClientResponse.responseDetail              = grd;
            _inquiryClientResponse.inquiryClientResponseData   = icrd;
            
        } catch (SOAPException ex) {            
            grd.responseCode               = "99";
            grd.responseDesc               = ex.toString();
            _inquiryClientResponse.responseCode     = "99"; 
            _inquiryClientResponse.responseDetail   = grd;
            _inquiryClientResponse.inquiryClientResponseData = icrd;
                       
        }catch (JAXBException | ClassNotFoundException | IOException | CloneNotSupportedException ex) {
            grd.responseCode               = "-1";
            grd.responseDesc               = ex.toString();
            _inquiryClientResponse.responseCode     = "-1"; 
            _inquiryClientResponse.responseDetail   = grd;   
        }finally{
            
            try {
                clientMsg.set_raw_response(_clientRawResponse);
                clientMsg.set_response_time(new Date());
                clientMsg.set_error_code(grd.responseCode);
                clientMsg.set_error_desc(grd.responseDesc);
                
                
                log.info(ObjectLoger(clientMsg));
                log.info(ObjectLoger(serverMsg));
                
                interfaceLog.Insert(clientMsg);
                if(serverMsg != null)
                    interfaceLog.Insert(serverMsg);
                
                
                _clientRawResponse = Marshalling(_inquiryClientResponse,"com.my.Helper.serviceObject.InquiryClientResponse");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InquiryClientRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    
    public InquiryClientResponse getRespond(){
        return _inquiryClientResponse;
    }
    
    
    public static void main(String[] args){
        
            ChannelHeader ch    = new ChannelHeader();
            ch.channelID = "asdf";
            ch.messageID = "fdadf";
            ch.reference = "234567";
            ch.transactiondate  = dateToString(new Date(),"dmy");
            ch.transactiontime  = dateToString(new Date(),"HH:mm:ss");
            
            InquiryClientRequestData ic = new InquiryClientRequestData();            
            ic.partnerID        = "CITICARGO";
            ic.clientID         = "LPX-0001";
            
            InquiryClientRequest icr = new InquiryClientRequest();
            icr.channelHeader   = ch;
            icr.inquiryClientRequestData = ic;
            
            InquiryClientRequestHandler m = new InquiryClientRequestHandler();
            
            
            m.InquiryClientService(icr);
            
    }
    
}

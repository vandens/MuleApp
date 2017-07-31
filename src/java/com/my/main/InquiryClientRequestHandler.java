
package com.my.main;

import com.my.Helper.serviceObject.InquiryClientRequest;
import com.my.Helper.serviceObject.InquiryClientRequestData;
import com.my.Helper.serviceObject.InquiryClientResponse;
import com.my.Helper.serviceObject.InquiryClientResponseData;
import com.my.Helper.serviceObject.ChannelHeader;
import com.my.Helper.serviceObject.GlobalResponseDetail;
import static com.my.Helper.General.*;
import static com.my.Helper.MarshallUnMarshall.Marshalling;
import static com.my.Helper.MarshallUnMarshall.UnMarshalling;
import com.my.Service.CitiCargo.CitiCargo;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;


public class InquiryClientRequestHandler {
    private String GlobalRespCode, DetailRespCode, DetailRespDesc = "";
    private String ClientID, ClientName, ClientDesc = "";
    
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
        
        try {
            
            _clientRawRequest = Marshalling(RequestData,"com.my.Helper.serviceObject.InquiryClientRequest");            
            if(RequestData.inquiryClientRequestData.partnerID.equalsIgnoreCase("CITICARGO")){                
                CitiCargo citiCargo     = new CitiCargo();
                citiCargo.InquiryClient(RequestData.inquiryClientRequestData.clientID);
                _serverRawRequest       = citiCargo.getrawRequest();
                _serverRawResponse      = citiCargo.getrawResponse();
                CitiCargo_InquiryClientResponse x = (CitiCargo_InquiryClientResponse) UnMarshalling(_serverRawResponse, "com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse");
                
                //set response
                ClientID             = RequestData.inquiryClientRequestData.clientID;
                ClientName           = x.InquiryClientResult.Respond[1];
                //ClientStatus         = x.InquiryClientResult.Respond[2];
                ClientDesc           = x.InquiryClientResult.Respond[3]; 
            }
            
            grd.responseCode            = "00";
            grd.responseDesc            = "Success";
            icrd.clientID               = ClientID;
            icrd.clientName             = ClientName;
            icrd.clientDesc             = ClientDesc;
            _inquiryClientResponse.responseCode                = "00";
            _inquiryClientResponse.responseDetail              = grd;
            _inquiryClientResponse.inquiryClientResponseData   = icrd;
            _clientRawResponse = Marshalling(_inquiryClientResponse,"com.my.Helper.serviceObject.InquiryClientResponse");

                       
            
        } catch (SOAPException ex) {
            
            grd.responseCode               = "60";
            grd.responseDesc               = ex.toString();
            _inquiryClientResponse.responseCode     = "60"; 
            _inquiryClientResponse.responseDetail   = grd;
            _inquiryClientResponse.inquiryClientResponseData = icrd;
            try {
                _clientRawResponse = Marshalling(_inquiryClientResponse,"com.my.Helper.serviceObject.InquiryClientResponse");
            } catch (ClassNotFoundException ex1) {
                Logger.getLogger(InquiryClientRequestHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }catch (JAXBException | ClassNotFoundException | IOException ex) {
            grd.responseCode               = "XX";
            grd.responseDesc               = ex.toString();
            _inquiryClientResponse.responseCode     = "XX"; 
            _inquiryClientResponse.responseDetail   = grd; 
            try {
                _clientRawResponse = Marshalling(_inquiryClientResponse,"com.my.Helper.serviceObject.InquiryClientResponse");
            } catch (ClassNotFoundException ex1) {
                Logger.getLogger(InquiryClientRequestHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
                      
        }finally{
            log.log(Level.INFO, "_clientRequest : {0}", _clientRawRequest);
            log.log(Level.INFO, "_serverRequest : {0}", _serverRawRequest);
            log.log(Level.INFO, "_serverResponse : {0}", _serverRawResponse); 
            log.log(Level.INFO, "_clientResponse : {0}", _clientRawResponse);

        }
        
        
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
            ic.clientID         = "LPX-0001";
            
            InquiryClientRequest icr = new InquiryClientRequest();
            icr.channelHeader   = ch;
            icr.inquiryClientRequestData = ic;
            
            InquiryClientRequestHandler m = new InquiryClientRequestHandler();
            
            
            m.InquiryClientService(icr);
            
    }
    
}

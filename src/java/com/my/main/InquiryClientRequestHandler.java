
package com.my.main;

import com.my.API.PartnerAPI;
import static com.my.API.PartnerAPI.interfaceLog;
import static com.my.API.PartnerAPI.masterServices;
import static com.my.Helper.General.ObjectLoger;
import static com.my.Helper.General.dateToString;
import static com.my.Helper.MarshallUnMarshall.Marshalling;
import com.my.Helper.serviceObject.*;
import com.my.Objects.InterfaceLogObject;
import com.my.Service.LionExpress.*;
import com.my.Service.Partners;
import com.my.Service.WSClient;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.xml.transform.StringResult;


/**
 *
 * @author Vandens mc Maddens
 */

public class InquiryClientRequestHandler {
    private String partnerID;
    private String clientID;
    private Partners partners;
    
    private WSClient wsClient = new WSClient();
    
    private String GlobalRespCode = "";
    private String DetailRespCode = "";
    private String DetailRespDesc = "";
    private StringResult ChannelRequestMsg  = new StringResult();
    private StringResult ChannelResponseMsg = new StringResult();
    private String PartnerRequestMsg;//  = new StringResult();
    private String PartnerResponseMsg;// = new StringResult();
    
    //logging
    private InterfaceLogObject   clientMsg  = new InterfaceLogObject();
    private InterfaceLogObject   serverMsg  = null;

    private InquiryAgentResponse inquiryAgentResponse   = new InquiryAgentResponse();
    private GlobalResponseDetail responDetail           = new GlobalResponseDetail();
    private InquiryAgentResponseData responData         = new InquiryAgentResponseData();
    
    public void InquiryClientService(InquiryAgentRequest RequestData) {
        try{
            partnerID        = RequestData.inquiryClientRequestData.partnerID.toUpperCase();
            clientID         = RequestData.inquiryClientRequestData.clientID;
            partners         = masterServices.partners(partnerID);

            //create object for client side message logging
            clientMsg.set_auto(0);
            clientMsg.set_uid(RequestData.channelHeader.messageID);
            clientMsg.set_channel_id(RequestData.channelHeader.channelID);
            clientMsg.set_feature_id(RequestData.inquiryClientRequestData.partnerID);
            clientMsg.set_function_name("InquiryClientService (Client)");
            clientMsg.set_log_date(new Date());
            clientMsg.set_send_time(new Date());

            serverMsg    = (InterfaceLogObject) clientMsg.clone();
            
            if("".equals(partners.getPartnerID()) || partners.getPartnerID() == null){
               responDetail.responseCode = "01";
               responDetail.responseDesc = "Invalid Data";
            }else{
               
                serverMsg.set_send_time(new Date());
                serverMsg.set_function_name("InquiryClientService (Server)");
                if(partners.getPartnerID().equalsIgnoreCase("lionexpress")){
                   
                   
                   LionExpress_InquiryClientHandler();
                                      
                    clientMsg.set_response_time(new Date());
                    clientMsg.set_error_code(responDetail.responseCode);
                    clientMsg.set_error_desc(responDetail.responseDesc);
                   
                   
                   serverMsg.set_raw_request(PartnerRequestMsg);
                   serverMsg.set_raw_response(PartnerResponseMsg);
                   serverMsg.set_response_time(new Date());
                   serverMsg.set_error_code(responData.clientError);
                   serverMsg.set_error_desc(responData.clientDesc);
                   
                }else{
                    responDetail.responseCode = "01";
                    responDetail.responseDesc = "Invalid Data";              
                }
                
            }  
            
        }catch(IOException ex){
               responDetail.responseCode = "01";
               responDetail.responseDesc = "Invalid Data";
            
        } catch (CloneNotSupportedException ex) {
               responDetail.responseCode = "01";
               responDetail.responseDesc = "Invalid Data";
            
        }finally{
            
            try {
                
                inquiryAgentResponse.responseCode   = responDetail.responseCode;
                inquiryAgentResponse.responseDetail = responDetail;
                inquiryAgentResponse.inquiryAgentResponseData = responData;

                ChannelRequestMsg    = wsClient.Marshalling(RequestData);
                ChannelResponseMsg   = wsClient.Marshalling(inquiryAgentResponse);
                clientMsg.set_raw_request(ChannelRequestMsg.toString());
                clientMsg.set_raw_response(ChannelResponseMsg.toString());
                
                System.out.println("clientMsg : "+ObjectLoger(clientMsg));
                System.out.println("serverMsg : "+ObjectLoger(serverMsg));
                
                //interfaceLog.Insert(clientMsg);
                //interfaceLog.Insert(serverMsg);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    private void LionExpress_InquiryClientHandler() throws IOException{
        
        LionExpress lex = new LionExpress(partners);
        lex.setWsClient(wsClient);
        lex.InquiryClient(clientID);
        responDetail.responseCode = lex.getChannelResponseCode();
        responDetail.responseDesc = lex.getChannelResponseDesc();
        PartnerRequestMsg         = lex.getPartnerRawRequest();
        PartnerResponseMsg        = lex.getPartnerRawResponse();
        
        if(lex.getChannelResponseCode().equals("00")){ // kalo sukses aja
            LionExpress_InquiryClientResponse respon = (LionExpress_InquiryClientResponse) lex.getWsClient().getResponseObject();
            //{LPX-0001,Harapan Travel,01,Exist} 
            responData.clientID     = respon.InquiryClientResult.Respond[0];
            responData.clientName   = respon.InquiryClientResult.Respond[1];
            responData.clientError  = respon.InquiryClientResult.Respond[2];
            responData.clientDesc   = respon.InquiryClientResult.Respond[3];
            
            inquiryAgentResponse.responseCode = lex.getChannelResponseCode();
            inquiryAgentResponse.responseDetail = responDetail;
            inquiryAgentResponse.inquiryAgentResponseData = responData;
        }
    }
    
    public InquiryAgentResponse getInquiryAgentResponse(){
        return inquiryAgentResponse;
    }
    
    
    public static void main(String[] args){
            PartnerAPI p = new PartnerAPI();
            
            ChannelHeader ch    = new ChannelHeader();
            ch.channelID = "asdf";
            ch.messageID = "fdadf";
            ch.reference = "234567";
            ch.transactiondate  = dateToString(new Date(),"ymd");
            ch.transactiontime  = dateToString(new Date(),"HHmmss");
            ch.branchCode = "asdf";
            ch.clientSupervisorID = "adf";
            ch.clientUserID = "fdsa";
            ch.sequenceno = "fad";
            
            
            InquiryAgentRequestData ic = new InquiryAgentRequestData();            
            ic.partnerID        = "lionexpress";
            ic.clientID         = "LPX-0001";
            
            InquiryAgentRequest icr = new InquiryAgentRequest();
            icr.channelHeader   = ch;
            icr.inquiryClientRequestData = ic;
            
            InquiryClientRequestHandler m = new InquiryClientRequestHandler();
            
            
            m.InquiryClientService(icr);
            InquiryAgentResponse x = m.getInquiryAgentResponse();
    }
    
}

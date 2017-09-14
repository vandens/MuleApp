
package com.my.Service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.WebServiceTransportException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.xml.transform.StringResult;

/**
 *
 * @author Vandens mc Maddens
 */
public class SoapWsClient extends WebServiceTemplate{
    
    private String    EndPoint;
    private Integer   WaitTimeout;
    private Integer   SoTimeout;
    private boolean   IsTimeout;
    private String    RawRequest;
    private String    RawResponse;
    private Object    RequestObject;
    private Object    ResponseObject;
    private String    ResponseCode;
    private String    ResponseDesc;
    private WebServiceTemplate webServiceTemplate;
    private HttpComponentsMessageSender httpMessageSender = new HttpComponentsMessageSender();
    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    
    public SoapWsClient(){
        try {
            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
            messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
            messageFactory.afterPropertiesSet();
            webServiceTemplate   = new WebServiceTemplate(messageFactory);
        } catch (SOAPException ex) {
            ResponseCode    = "-1";
            ResponseDesc    = ex.getMessage(); 
        }
    }
    
    public void call(){
        
        StringResult request    = new StringResult();
        StringResult response   = new StringResult();
        
        try { 
            webServiceTemplate.setMessageSender(httpMessageSender);
            webServiceTemplate.setMarshaller(marshaller);
            webServiceTemplate.setUnmarshaller(marshaller);
            webServiceTemplate.afterPropertiesSet();
            ResponseObject = webServiceTemplate.marshalSendAndReceive(EndPoint, RequestObject);
            webServiceTemplate.getMarshaller().marshal(ResponseObject, response);
        
            webServiceTemplate.getMarshaller().marshal(RequestObject, request);
            
            ResponseCode    = "00";
            ResponseDesc    = "Success";
            
        } catch (IOException | XmlMappingException ex) {
            ResponseCode    = "99";
            ResponseDesc    = ex.getMessage();
        }catch (WebServiceTransportException ex){
            ResponseCode    = "-1";
            ResponseDesc    = ex.getMessage();
        }catch (WebServiceIOException ex){
            if(ex.getMessage().toLowerCase().indexOf("refused") != -1 || ex.getMessage().indexOf("404") != -1){   
                ResponseCode    = "-1";
                ResponseDesc    = ex.getMessage(); 
            }else{                       
                ResponseCode    = "99";
                ResponseDesc    = ex.getMessage();  
            }    
        }finally{            
            RawRequest = request.toString();
            RawResponse = response.toString();            
        }
    }
    
    public void setEndPoint(String param){
        this.EndPoint = param;
    }
    public String getEndPoint(){
        return EndPoint;
    }
    public void setWaitTimeout(Integer param){
        httpMessageSender.setConnectionTimeout(param * 1000);
        this.WaitTimeout = param;
    }
    public Integer getWaitTimeout(){
        return WaitTimeout;
    }
    public void setSoTimeout(Integer param){
        httpMessageSender.setReadTimeout(param * 1000);
        this.SoTimeout = param;
    }
    public Integer getSoTimeout(){
        return SoTimeout;
    }
    public void setIsTimeout(boolean param){
        this.IsTimeout = param;
    }
    public boolean IsTimeout(){
        return IsTimeout;
    }
    public void setRawRequest(String param){
        this.RawRequest     = param;
    }
    public String getRawRequest(){
        return RawRequest;
    }
    public void setRawResponse(String param){
        this.RawResponse = param;
    }
    public String getRawResponse(){
        return RawResponse;
    }
    public void setRequestObject(Object param){
        this.RequestObject = param;
    }
    public Object getRequestObject(){
        return RequestObject;
    }
    public void setResponseObject(Object param){
        this.ResponseObject = param;
    }
    public Object getResponseObject(){
        return ResponseObject;
    }
    public void setResponseCode(String param){
        this.ResponseCode = param;
    }
    public String getResponseCode(){
        return ResponseCode;
    }
    public void setResponseDesc(String param){
        this.ResponseDesc = param;
    }
    public String getResponseDesc(){
        return ResponseDesc;
    }
    public void setMarshal(Class<?>[] x){
        marshaller.setClassesToBeBound(x);
        try {
            marshaller.afterPropertiesSet();
        } catch (Exception ex) {
            ResponseCode    = "99";
            ResponseDesc    = ex.getMessage();
        }
    }
    
    public static void main(String[] args){
        SoapWsClient ws = new SoapWsClient();
        ws.setEndPoint("http://localhost:8080/simulator/CargoService");
        ws.setWaitTimeout(10);
        ws.setSoTimeout(10);
        
        Class<?>[] x  = new Class[4];
        try {
            x[0] = Class.forName("com.my.Helper.serviceObject.InquiryAgentRequest");
            x[1] = Class.forName("com.my.Helper.serviceObject.InquiryAgentResponse");
            x[2] = Class.forName("com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData");
            x[3] = Class.forName("com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse");
            ws.setMarshal(x);
        } catch (ClassNotFoundException ex) {
            System.out.println("classnotfound : "+ex.toString());
        }
        
        com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData xx = new com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData();
        xx.customer_id = "LPX-0001";
        ws.setRequestObject(xx);
        ws.call();
        System.out.println(ws.IsTimeout);
        System.out.println(ws.RawRequest);
        System.out.println(ws.RawResponse);
        System.out.println(ws.getResponseCode());
        System.out.println(ws.getResponseDesc());
        System.out.println(ws.getRequestObject());
    }


    
    
}

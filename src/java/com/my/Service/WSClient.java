
package com.my.Service;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.WebServiceTransportException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

/**
 *
 * @author Vandens mc Maddens
 */
public class WSClient extends WebServiceTemplate{
    
    protected String    EndPoint;
    protected Integer   WaitTimeout;
    protected Integer   SoTimeout;
    protected boolean   IsTimeout;
    protected String    RawRequest;
    protected String    RawResponse;
    protected Object    RequestObject;
    protected Object    ResponseObject;
    protected String    ResponseCode;
    protected String    ResponseDesc;
    protected SaajSoapMessageFactory messageFactory;
    protected WebServiceTemplate webServiceTemplate;
    protected HttpComponentsMessageSender httpMessageSender = new HttpComponentsMessageSender();
    protected Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    
    public WSClient(){
        
        try {
            messageFactory = new SaajSoapMessageFactory();
            messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
            //messageFactory.afterPropertiesSet();
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
            webServiceTemplate.getMarshaller().marshal(RequestObject, request);
            ResponseObject = webServiceTemplate.marshalSendAndReceive(EndPoint, RequestObject);
            webServiceTemplate.getMarshaller().marshal(ResponseObject, response);
        
            
            ResponseCode    = "00";
            ResponseDesc    = "Success";
            
        } catch (IOException | XmlMappingException ex) {
            IsTimeout       = true;
            ResponseCode    = "99";
            ResponseDesc    = ex.getMessage();
        }catch (WebServiceTransportException ex){
            ResponseCode    = "-1";
            ResponseDesc    = ex.getMessage();
        }catch (WebServiceIOException ex){
            if(ex.getMessage().toLowerCase().contains("refused") || ex.getMessage().contains("404")){   
                ResponseCode    = "-1";
                ResponseDesc    = ex.getMessage(); 
            }else{                       
                IsTimeout       = true;
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
    public void setJaxbMarshaller(){
        this.marshaller = new Jaxb2Marshaller();
    }
    public Jaxb2Marshaller getJaxbMarshaller(){
        return marshaller;
    }
    public WebServiceTemplate getWsTemplate(){
        return webServiceTemplate;
    }
    public void setMarshallByClass(Class<?>[] x){
        marshaller.setClassesToBeBound(x);
        try {
            marshaller.afterPropertiesSet();
        } catch (Exception ex) {
            ResponseCode    = "99";
            ResponseDesc    = ex.getMessage();
        }
    }
    
    public String Marshalling(Object dataObject) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        StringResult message = new StringResult();
        //create new instance
        Constructor ctor = this.getClass().getDeclaredConstructor();
        ctor.setAccessible(true);
        WSClient wsClient = (WSClient) ctor.newInstance();
        wsClient.getJaxbMarshaller().setContextPath(dataObject.getClass().getPackage().getName());
        wsClient.getJaxbMarshaller().marshal(dataObject, message);
        String msg  = message.toString();
        return msg;
    }
    
    public Object UnMarshalling(String XmlString, Object object) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        
        StringSource xml            = new StringSource(XmlString);
        //create new instance
        Constructor ctor = this.getClass().getDeclaredConstructor();
        ctor.setAccessible(true);
        WSClient wsClient = (WSClient) ctor.newInstance();
        wsClient.getJaxbMarshaller().setClassesToBeBound(object.getClass());

        Object obj = wsClient.getJaxbMarshaller().unmarshal(xml);

        return obj;
    }
   
}

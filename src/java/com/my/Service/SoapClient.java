
package com.my.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;


public class SoapClient {
    
    protected String   _endpoint;
    protected String   _class;
    protected Object   _data;
    protected Integer  _timeout;
    public String   _rawRequest;
    public String   _rawResponse;
    
    public SoapClient(){}
    
    
    public SoapClient(String endpoint, String classname, Object data, Integer timeout){
            this._endpoint  = endpoint;
            this._class     = classname;
            this._data      = data;
            this._timeout   = timeout;
    }
    
    public SoapClient(Map<String, Object> datax) {
            this._endpoint  = (String) datax.get("EndPoint");
            this._class     = (String) datax.get("ClassObj");
            this._data      = datax.get("RequestData");
            this._timeout   = (Integer) datax.get("TimeOut");
    }
    
    public void call() throws SOAPException, JAXBException, ClassNotFoundException, IOException{
        
            //Create Soap Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            //Create Soap Message
            MessageFactory messageFactory   = MessageFactory.newInstance();
            SOAPMessage soapMessage         = messageFactory.createMessage();
            SOAPPart soapPart               = soapMessage.getSOAPPart();
            SOAPBody soapBody               = soapMessage.getSOAPBody(); 
            SOAPEnvelope envelope           = soapPart.getEnvelope();
            //add namespace
            envelope.addNamespaceDeclaration("ns1", _endpoint);
            
            //marshalling object
            JAXBContext jc                  = JAXBContext.newInstance(Class.forName(_class));
            Marshaller marshaller           = jc.createMarshaller();
            marshaller.marshal(_data, soapBody);

            //commit message
            soapMessage.saveChanges();

            //set request message - raw data
            ByteArrayOutputStream req   = new ByteArrayOutputStream();
            soapMessage.writeTo(req);
            this._rawRequest            = new String(req.toByteArray());
            //post request
            SOAPMessage soapResponse    = soapConnection.call(soapMessage, _endpoint);

            //set response message - raw data
            ByteArrayOutputStream res   = new ByteArrayOutputStream();
            soapResponse.writeTo(res);
            this._rawResponse           = new String(res.toByteArray());
            
            SOAPMessage x = soapResponse;
            soapConnection.close();
    }
    
    
    public void setEndPoint(String param){
        this._endpoint  = param;
    }    
    public void setTimeOut(Integer param){
        this._timeout   = param;
    }
    public void setData(Object param){
        this._data      = param;
    }
    public void setClassName(String param){
        this._class     = param;
    }
    private void setRawRequest(String param){
        this._rawRequest   = param;
    }   
    private void setRawResponse(String param){
        this._rawResponse  = param;
    }    
    public String getEndPoint(){
        return this._endpoint;
    }
    public Integer getTimeOut(){
        return this._timeout;
    }
    public Object getData(){
        return this._data;
    }
    public String getClassName(){
        return this._class;
    }
    public String getRawRequest(){
        return this._rawRequest;
    }    
    public String getRawResponse(){
        return this._rawResponse;
    }
    
    
}

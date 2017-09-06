package com.my.main;

import java.io.StringReader;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.http.client.HttpClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@ContextConfiguration("serviceContext.xml") 
public class WebServiceClient  {

    private static final String MESSAGE = "<car:InquiryClient xmlns:car=\"http://localhost:8080/simulator/CargoService\"><car:customer_id>LPX-0001</car:customer_id></car:InquiryClient>";

    private final WebServiceTemplate webServiceTemplate     = new WebServiceTemplate();
    private final HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
    
    public WebServiceClient(){
        messageSender.setReadTimeout(6);
        messageSender.setConnectionTimeout(6);
        webServiceTemplate.setCheckConnectionForError(true);
    }
   
    
    public static void main(String[] args){
        try{
            WebServiceClient nx = new WebServiceClient();
        
            nx.customSendAndReceive();
        }catch(org.springframework.ws.client.WebServiceTransportException ex){
            System.out.println("WebServiceTransportException : "+ex.getMessage());
        }catch(org.springframework.ws.client.WebServiceIOException ex){
            System.out.println("WebServiceIOException : "+ex.getMessage());
        }
        System.exit(0);
    }
    
    public void setDefaultUri(String defaultUri) {
        webServiceTemplate.setDefaultUri(defaultUri);
    }

    // send to the configured default URI
    public void simpleSendAndReceive() {        
        StreamSource source = new StreamSource(new StringReader(MESSAGE));
        StreamResult result = new StreamResult(System.out);
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);
    }

    // send to an explicit URI
    public void customSendAndReceive() {
        System.out.println(MESSAGE);
        StreamSource source = new StreamSource(new StringReader(MESSAGE));
        
        StreamResult result = new StreamResult(System.out);
        webServiceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/simulator/CargoService",
            source, result);
    }
    

}
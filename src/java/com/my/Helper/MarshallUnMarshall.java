
package com.my.Helper;

import static com.my.Helper.General.ObjectLoger;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientResult;
import com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


public class MarshallUnMarshall {
    
    public static String Marshalling(Object Data, String ClassName) throws ClassNotFoundException{
        
        try {
            SOAPMessage soapMessage         = MessageFactory.newInstance().createMessage();
            org.w3c.dom.Document document   =  DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            JAXBContext jaxb                = JAXBContext.newInstance(ClassName); //Class.forName(ClassName));
            
            Marshaller marshaller           = jaxb.createMarshaller();
            marshaller.marshal(Data, document);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            soapMessage.getSOAPBody().addDocument((org.w3c.dom.Document) document);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            soapMessage.writeTo(outputStream);
            
            // ganti format ke String
            String output = new String(outputStream.toByteArray());
            
            return output;
        } catch (SOAPException | ParserConfigurationException | JAXBException | IOException ex) {
            Logger.getLogger(MarshallUnMarshall.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Object UnMarshalling(String XmlString, String ClassName) throws SOAPException, IOException, JAXBException, ClassNotFoundException{
        
        SOAPMessage message         = MessageFactory.newInstance().createMessage(null,
                                                                                    new ByteArrayInputStream(XmlString.getBytes()));
        Unmarshaller unmarshaller   = JAXBContext.newInstance(Class.forName(ClassName)).createUnmarshaller();
        Object Obj = (Object)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
       
        return Obj;
    }
    
    
    
    public static void main(String[] args) throws ParserConfigurationException, ClassNotFoundException{
        try {
            
            String[] d  = new String[4];
            d[0] = "fsadf";
            d[1] = "fdsa";
            d[2] = "fdsasdf";
            d[3] = "ewqer";
            
            CitiCargo_InquiryClientResult ic = new CitiCargo_InquiryClientResult();
            ic.Respond = d;
            
            CitiCargo_InquiryClientResponse tu = new CitiCargo_InquiryClientResponse();
            tu.InquiryClientResult = ic;
            String xx = Marshalling(tu,"com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse");
            System.out.println(xx);
            System.out.println(d.toString());
            //String XmlString = Marshalling(tu,"com.my.Service.CitiCargo.CitiCargo_InquiryClientResponse");
            //System.out.println(XmlString);
            String XmlString = "<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><ns2:InquiryClientResponse xmlns:ns2=\"http://localhost:8080/simulator/CargoService\" xmlns:ns3=\"http://localhost:8080/simulator/KSService/CargoReportObj\"><InquiryClientResult><anyType>LPX-0001</anyType><anyType>Harapan Travel</anyType><anyType>01</anyType><anyType>Exist</anyType></InquiryClientResult></ns2:InquiryClientResponse></S:Body></S:Envelope>";
            
            CitiCargo_InquiryClientResponse namespace = new CitiCargo_InquiryClientResponse();
            
            SOAPMessage message         = MessageFactory.newInstance().createMessage(null,
                    new ByteArrayInputStream(XmlString.getBytes()));
            Unmarshaller unmarshaller   = JAXBContext.newInstance(namespace.getClass()).createUnmarshaller();
            CitiCargo_InquiryClientResponse Obj = (CitiCargo_InquiryClientResponse)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
            
            System.out.println(ObjectLoger(Obj));
            
            
        } catch (IOException ex) {
            Logger.getLogger(MarshallUnMarshall.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(MarshallUnMarshall.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SOAPException ex) {
            Logger.getLogger(MarshallUnMarshall.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

   
    
}

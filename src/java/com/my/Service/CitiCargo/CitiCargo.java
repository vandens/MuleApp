
package com.my.Service.CitiCargo;

import static com.my.Helper.MarshallUnMarshall.UnMarshalling;
import com.my.Service.SoapClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
import static com.my.main.InquiryClientRequestHandler.*;


public class CitiCargo extends SoapClient{
    
    private String _endpoint  = "http://localhost:8080/simulator/CargoService";
    //private String _endpoint  = "http://localhost:8080/simulator/CargoService";
    //private String _rawResponse;
    //private String _rawRequest;
    
    
    public CitiCargo(){}
    public CitiCargo(Map<String, Object> datax) 
    {
        this._endpoint  = (String) datax.get("EndPoint");
        this._class     = (String) datax.get("ClassObj");
        this._timeout   = (Integer) datax.get("TimeOut");
        this._data      = datax.get("RequestData");
    }
    
    public void InquiryClient(String ClientID) throws SOAPException, JAXBException, ClassNotFoundException, IOException
    {
        CitiCargo_InquiryClientRequestData inquiry    = new CitiCargo_InquiryClientRequestData();
        inquiry.customer_id                 = ClientID;
        
        Map<String, Object> request         = new HashMap<String, Object>();
        request.put("EndPoint", _endpoint);
        request.put("ClassObj", "com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData");
        request.put("TimeOut",30);
        request.put("RequestData", inquiry);
        
        SoapClient sc   = new SoapClient(request);
        sc.call();
        _serverRawRequest  = sc._rawRequest;
        _serverRawResponse = sc._rawResponse;
    }
    
    
    
    public void SendPaymentReport(){
        
        
    }
    
    
}

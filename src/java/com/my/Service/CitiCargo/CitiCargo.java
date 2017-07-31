
package com.my.Service.CitiCargo;

//import static com.my.Helper.MarshallUnMarshall.UnMarshalling;
import com.my.Service.SoapClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
//import static com.my.main.InquiryClientRequestHandler.*;


public class CitiCargo extends SoapClient{
    
    private static String _partner_id, _partner_name, _wsdl_path, _wait_timeout, _decrypt_check, _encrypt_iv, _encrypt_key;

    private String _rawResponse;
    private String _rawRequest;
    
    
    public CitiCargo(){
         setProperty();
    }
        
    public CitiCargo(Map<String, Object> datax) 
    {
        setProperty();
        this._endpoint  = (String) datax.get("EndPoint");
        this._class     = (String) datax.get("ClassObj");
        this._timeout   = (Integer) datax.get("TimeOut");
        this._data      = datax.get("RequestData");
    }
    
    private static void setProperty(){
        try {
            Properties prop = new Properties();
            prop.load(CitiCargo.class.getClassLoader().getResourceAsStream("partners.properties"));
            _partner_id     = prop.getProperty("citicargo.partner_id");
            _partner_name   = prop.getProperty("citicargo.partner_name");
            _wsdl_path      = prop.getProperty("citicargo.wsdl_path");
            _wait_timeout   = prop.getProperty("citicargo.wait_timeout");
            _decrypt_check  = prop.getProperty("citicargo.decrypt_check");
            _encrypt_iv     = prop.getProperty("citicargo.encrypt_iv");
            _encrypt_key    = prop.getProperty("citicargo.encrypt_key");
            
        } catch (IOException ex) {
            Logger.getLogger(CitiCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void InquiryClient(String ClientID) throws SOAPException, JAXBException, ClassNotFoundException, IOException
    {
        CitiCargo_InquiryClientRequestData inquiry    = new CitiCargo_InquiryClientRequestData();
        inquiry.customer_id                 = ClientID;
        
        Map<String, Object> request         = new HashMap<String, Object>();
        request.put("EndPoint", _wsdl_path);
        request.put("ClassObj", "com.my.Service.CitiCargo.CitiCargo_InquiryClientRequestData");
        request.put("TimeOut", Integer.parseInt(_wait_timeout));
        request.put("RequestData", inquiry);
        
        SoapClient sc   = new SoapClient(request);
        sc.call();
        
        this.setrawRequest(sc._rawRequest);
        this.setrawResponse(sc._rawResponse);
    }
    
    public void SendPaymentReport(){
            /*
            <payref>20170606M4KQ62ATY</payref>
            <paydate>20170606</paydate>
            <creditto>2138273770</creditto>
            <customer_id>CXUH8MkiLHlZ1i9sim1aXMJ2PhYiIBc43Ik9jmhuw60=</customer_id>
            <message>CP LCG-0003</message>
            <amount>zUc2p9NVv6QTHhYu0ztaziTQdCbzcMb8UA1hheKF0Ls=</amount>
            <ccy>IDR</ccy>
            <agent_decryptcheck>/WXJ57iDggh7/tTdoypAZgValTsLbIo+dAaninh3t30=</agent_decryptcheck>
            <field_checksum>c7e9f7282af3c0ec687e0dcab4146de1</field_checksum>
            <first_sent_time>20170606045955</first_sent_time>
            <last_sent_time>20170606045955</last_sent_time>
            */
    }
    
    
    
    public void setrawRequest(String rawRequest){
        this._rawRequest = rawRequest;
    }
    private void setrawResponse(String rawResponse){
        this._rawResponse = rawResponse;
    }
    public String getrawRequest(){
        return _rawRequest;
    }
    public String getrawResponse(){
        return _rawResponse;
    }
    
    
    public static void main(String[] args){
        try {
            
            setProperty();
            CitiCargo cc = new CitiCargo();
            cc.InquiryClient("IDX-0109");
            System.out.println(cc._rawRequest);
            System.out.println(cc._rawResponse);
        } catch (SOAPException ex) {
            Logger.getLogger(CitiCargo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(CitiCargo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CitiCargo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CitiCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

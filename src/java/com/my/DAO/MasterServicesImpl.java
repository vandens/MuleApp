
package com.my.DAO;

import static com.my.API.PartnerAPI.partnerProperty;
import com.my.Service.Partners;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author TP32447
 */
@Service(value="MasterServices")
public class MasterServicesImpl implements MasterServices{
    
    
    private Partners partners = new Partners();
    
    @Override
    public Partners partners(String param) {
        
        try{
        Map<String, String> map = partnerProperty.getSpesificMap(param);
        Integer soTimeout   = (map.get("so_timeout") == null ) ? 0 : Integer.valueOf(map.get("so_timeout"));
        Integer waitTimeout = (map.get("wait_timeout") == null ) ? 0 : Integer.valueOf(map.get("wait_timeout"));
        
        partners.setPartnerID(param);
        partners.setPartnerName(map.get("partner_name"));
        partners.setUserID(map.get("user_id"));
        partners.setUserPass(map.get("user_pass"));
        partners.setSoTimeout(soTimeout);
        partners.setWaitTimeout(waitTimeout);
        partners.setDecryptCheck(map.get("decrypt_check"));
        partners.setEncryptIV(map.get("encrypt_iv"));
        partners.setEncryptKey(map.get("encrypt_key"));
        partners.setWsdlPath(map.get("wsdl_path"));
        }catch(NullPointerException ex){
            
        } 
        return partners;
    }
    public static void main(String[] args){
        
        
    }
    
}

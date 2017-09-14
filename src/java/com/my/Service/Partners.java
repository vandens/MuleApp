
package com.my.Service;

/**
 *
 * @author Vandens mc Maddens
 */
public class Partners {
    
    private String PartnerID = "";
    private String PartnerName;
    private String UserID;
    private String UserPass;
    private Integer WaitTimeout;
    private Integer SoTimeout;
    private String DecryptCheck;
    private String EncryptIV;
    private String EncryptKey;
    private String WsdlPath;

    public void setPartnerID(String param){
        this.PartnerID     = param;
    }
    public void setPartnerName(String param){
        this.PartnerName   = param;
    }
    public void setUserID(String param){
        this.UserID         = param;
    }
    public void setUserPass(String param){
        this.UserPass       = param;
    }
    public void setWaitTimeout(Integer param){
        this.WaitTimeout   = param;
    }
    public void setSoTimeout(Integer param){
        this.SoTimeout     = param;
    }
    public void setDecryptCheck(String param){
        this.DecryptCheck   = param;
    }
    public void setEncryptIV(String param){
        this.EncryptIV      = param;
    }
    public void setEncryptKey(String param){
        this.EncryptKey     = param;
    }
    public void setWsdlPath(String param){
        this.WsdlPath       = param;
    }       
    public String getPartnerID(){
        return PartnerID;
    }
    public String getPartnerName(){
        return PartnerName;
    }
    public String getUserID(){
        return UserID;
    }
    public String getUserPass(){
        return UserPass;
    }
    public Integer getWaitTimeout(){
        return WaitTimeout;
    }
    public Integer getSoTimeout(){
        return SoTimeout;
    }
    public String getDecryptCheck(){
        return DecryptCheck;
    }
    public String getEncryptIV(){
        return EncryptIV;
    }
    public String getEncryptKey(){
        return EncryptKey;
    }
    public String getWsdlPath(){
        return WsdlPath;
    }

}

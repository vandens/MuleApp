
package com.my.Helper.serviceObject;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement//(name="GlobalResponse")
public class GlobalResponse {
    public String responseCode = "";
    @XmlElement(name="responseDetail")
    public GlobalResponseDetail responseDetail;
    @XmlElement(name="inquiryClientResponseData")
    public InquiryAgentResponseData InquiryClientResponseData;
    
    public GlobalResponse(){}
    public void setGlobalResponseDetail(){
        
    }
    public void setInquiryClientResponseData(){
        
    }
}


package com.my.Helper.serviceObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InquiryAgentResponse {
    public String responseCode;
    @XmlElement(name="responseDetail")
    public GlobalResponseDetail responseDetail;
    @XmlElement(name="inquiryAgentResponseData")
    public InquiryAgentResponseData inquiryAgentResponseData = null;
}

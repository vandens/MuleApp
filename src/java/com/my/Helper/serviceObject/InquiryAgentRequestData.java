
package com.my.Helper.serviceObject;

import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public class InquiryAgentRequestData {
    @XmlElement(name="partnerID", required=true)
    public String partnerID;
    @XmlElement(name="clientID", required=true)
    public String clientID;
}

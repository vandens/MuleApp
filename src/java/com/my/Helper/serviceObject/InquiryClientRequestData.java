
package com.my.Helper.serviceObject;

import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="InquiryClientRequest")
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public class InquiryClientRequestData {
    @XmlElement(name="clientID", required=true)
    public String clientID;
}

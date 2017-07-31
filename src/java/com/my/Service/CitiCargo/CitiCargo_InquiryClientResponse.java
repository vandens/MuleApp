
package com.my.Service.CitiCargo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="InquiryClientResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CitiCargo_InquiryClientResponse {
    @XmlElement(name="InquiryClientResult")
    public CitiCargo_InquiryClientResult InquiryClientResult = new CitiCargo_InquiryClientResult();
    
}




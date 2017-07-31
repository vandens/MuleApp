
package com.my.Service.CitiCargo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="InquiryClientResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class CitiCargo_InquiryClientResult {
    @XmlElement(name="anyType")
    public String[] Respond = new String[4];

}

package com.my.Helper.serviceObject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="InquiryClient")
@XmlAccessorType(XmlAccessType.FIELD)
public class InquiryClientRequest {
    @XmlElement(name = "ChannelHeader", required=true)
    public ChannelHeader channelHeader;
    @XmlElement(name="InquiryClientRequest", required=true)
    public InquiryClientRequestData inquiryClientRequestData;
}
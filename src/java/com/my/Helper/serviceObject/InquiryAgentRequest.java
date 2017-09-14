
package com.my.Helper.serviceObject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="InquiryAgent")
public class InquiryAgentRequest {
    @XmlElement(name = "ChannelHeader", required=true)
    public ChannelHeader channelHeader;
    @XmlElement(name="InquiryAgentRequest", required=true)
    public InquiryAgentRequestData inquiryClientRequestData;
}
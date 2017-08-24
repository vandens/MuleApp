
package com.my.Helper.serviceObject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChannelHeader {
    @XmlElement(name="messageID")
    public String messageID;
    public List<AdditionalHeader> additionalHeader = new ArrayList();
    @XmlElement(name="branchCode")
    public String branchCode;
    @XmlElement(name="channelID")
    public String channelID;
    @XmlElement(name="clientSupervisorID")
    public String clientSupervisorID;
    @XmlElement(name="clientUserID")
    public String clientUserID;
    @XmlElement(name="reference")
    public String reference;
    @XmlElement(name="sequenceno")
    public String sequenceno;
    @XmlElement(name="transactiondate")
    public String transactiondate;
    @XmlElement(name="transactiontime")
    public String transactiontime;

    private static class AdditionalHeader {
        public AdditionalHeader() {}
    }
    
}

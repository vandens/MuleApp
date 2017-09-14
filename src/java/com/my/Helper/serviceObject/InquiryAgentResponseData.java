
package com.my.Helper.serviceObject;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class InquiryAgentResponseData {    
    public String clientID;
    public String clientName;
    @XmlTransient
    public String clientError;
    public String clientDesc;
}

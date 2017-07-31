
package com.my.Service.CitiCargo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vandens
 */
@XmlRootElement(name="ns1:SendPaymentReport", namespace="")
public class CitiCargo_SyncPaymentRequestData {    
    public String payref;
    public String paydate;
    public String creditto;
    public String customer_id;
    public String message;
    public String amount;
    public String ccy;
    public String agent_decryptcheck;
    public String field_checksum;
    public String first_sent_time;
    public String last_sent_time;
}

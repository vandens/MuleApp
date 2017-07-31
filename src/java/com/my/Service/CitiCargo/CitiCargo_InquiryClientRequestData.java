
package com.my.Service.CitiCargo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="InquiryClient", namespace="http://10.225.16.55:8080/simulator/CargoService")
public  class CitiCargo_InquiryClientRequestData {
    public String customer_id;
}

@XmlSchema(
    namespace = "http://localhost:8080/simulator/CargoService",
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns = {
        @XmlNs(prefix="SOAP-ENV", namespaceURI="http://schemas.xmlsoap.org/soap/envelope/"),
        @XmlNs(prefix="ns1", namespaceURI="http://localhost:8080/simulator/CargoService")
    }
)  
package com.my.Service.CitiCargo;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;



package com.my.main;

import javax.xml.bind.annotation.XmlRegistry;

/**
 *
 * @author Vandens mc Maddens
 */

@XmlRegistry
public class ObjectFactory {
    
    public ObjectFactory() {}

    /**
     * Create an instance of {@link createLionExpress_InquiryClientRequestData }
     * @return 
     */
    public InquiryClientRequestHandler createInquiryClientRequestHandler() {
        return new InquiryClientRequestHandler();
    }
    
}
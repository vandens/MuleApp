
package com.my.Helper.serviceObject;

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
    public ChannelHeader createChannelHeader() {
        return new ChannelHeader();
    }
    
    /**
     * Create an instance of {@link GlobalResponse }
     * @return 
     */
    public GlobalResponse createGlobalResponse() {
        return new GlobalResponse();
    }
    
    /**
     * Create an instance of {@link GlobalResponseDetail }
     * @return 
     */
    public GlobalResponseDetail createGlobalResponseDetail() {
        return new GlobalResponseDetail();
    }
    
    /**
     * Create an instance of {@link InquiryAgentRequest }
     * @return 
     */
    public InquiryAgentRequest createInquiryAgent() {
        return new InquiryAgentRequest();
    }    
    /**
     * Create an instance of {@link InquiryAgentRequestData }
     * @return 
     */
    public InquiryAgentRequestData createInquiryAgentRequestData() {
        return new InquiryAgentRequestData();
    }
    
    /**
     * Create an instance of {@link InquiryAgentResponse }
     * @return 
     */
    public InquiryAgentResponse createInquiryAgentResponse() {
        return new InquiryAgentResponse();
    }
    
    /**
     * Create an instance of {@link InquiryAgentResponseData }
     * @return 
     */
    public InquiryAgentResponseData createInquiryAgentResponseData() {
        return new InquiryAgentResponseData();
    }
    
    /**
     * Create an instance of {@link ResponseDetail }
     * @return 
     */
    public ResponseDetail createResponseDetail() {
        return new ResponseDetail();
    }
    
    /**
     * Create an instance of {@link ServiceObject }
     * @return 
     */
    public ServiceObject createServiceObject() {
        return new ServiceObject();
    }
    
    /**
     * Create an instance of {@link TBRObject }
     * @return 
     */
    public TBRObject createTBRObject() {
        return new TBRObject();
    }
    
}
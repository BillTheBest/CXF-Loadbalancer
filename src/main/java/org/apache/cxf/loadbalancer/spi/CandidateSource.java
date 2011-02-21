package org.apache.cxf.loadbalancer.spi;

import java.util.List;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.message.Message;

/**
 * Determines the list of candidates for a given endpoint. Every return message will be give to the source
 * for inspection so it can decide about e.g. blacklisting  
 */
public interface CandidateSource {
    /**
     * Determine the list of candidates for a given endpoint. This method will be
     * called before each call to a service so the candidate list can be adapted.
     * 
     * @param endpoint
     * @return list of current candidates for the given endpoint 
     */
    public List<Endpoint> getCandidatesFor(final Endpoint endpoint);
    
    /**
     * Each return message is given to this method for inspection so the class can adapt the
     * candidates list to the history of messages. 
     * @param message
     */
    public void inspectReturnMessage(final Message message);
}

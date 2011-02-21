package org.apache.cxf.loadbalancer.spi;

import org.apache.cxf.message.Message;

public interface MessageAnalyzer {
    
    /**
     * Analyzes the return message and decides if there is an error and what kind of error
     * 
     * @param message
     * @return error type
     */
    public MessageErrorType analyze(Message message);
}

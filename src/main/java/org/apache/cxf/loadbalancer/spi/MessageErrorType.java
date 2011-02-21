package org.apache.cxf.loadbalancer.spi;

public enum MessageErrorType {
    /**
     * No error was detected
     */
    OK, 
    
    /**
     * Error was detected but next call may succeed 
     */
    RETRYABLE,
    
    /**
     * Error was detected next call will probably also fail
     */
    PERMANENT
}

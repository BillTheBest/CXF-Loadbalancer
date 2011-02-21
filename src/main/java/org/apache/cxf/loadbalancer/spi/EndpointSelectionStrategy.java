package org.apache.cxf.loadbalancer.spi;

import java.util.List;

import org.apache.cxf.endpoint.Endpoint;

public interface EndpointSelectionStrategy {
    /**
     * Decide which endpoint to use from a list of candidates
     * 
     * @param candidates
     * @return
     */
    public Endpoint selectEndpoint(final List<Endpoint> candidates);
}

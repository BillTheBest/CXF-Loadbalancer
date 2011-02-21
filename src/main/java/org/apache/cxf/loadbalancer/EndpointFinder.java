package org.apache.cxf.loadbalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.service.Service;

public class EndpointFinder {
    
    private EndpointFinder() {
        // Just to make sure this class is only used statically
    }
    
    /**
     * Get endpoints that are suitable to replace the current endpoint 
     * 
     * @param endpoint current endpoint
     * @return a List of candidate endpoints including the current endpoint
     */
    public static List<Endpoint> getCandidateEndpoints(Endpoint endpoint) {
        Service service = endpoint.getService();
        QName currentBinding = endpoint.getBinding().getBindingInfo().getName();
        List<Endpoint> alternates = new ArrayList<Endpoint>();
            Map<QName, Endpoint> candidates = service.getEndpoints();
            for (Endpoint candidate : candidates.values()) {
                QName candidateBinding = candidate.getBinding().getBindingInfo().getName();
                if (candidateBinding.equals(currentBinding)) {
                    alternates.add(candidate);
                }
            }
        return alternates;
    }
    
}

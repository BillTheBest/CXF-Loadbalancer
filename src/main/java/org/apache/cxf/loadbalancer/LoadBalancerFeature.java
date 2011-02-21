package org.apache.cxf.loadbalancer;
import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.loadbalancer.spi.CandidateSource;
import org.apache.cxf.loadbalancer.spi.EndpointSelectionStrategy;


public class LoadBalancerFeature extends AbstractFeature {
    EndpointSelectionStrategy endpointSelectionStrategy;
    CandidateSource candidateSource;
    
    public LoadBalancerFeature() {
    }

    public void setEndpointSelectionStrategy(EndpointSelectionStrategy endpointSelectionStrategy) {
        this.endpointSelectionStrategy = endpointSelectionStrategy;
    }

    public void setCandidateSource(CandidateSource candidateSource) {
        this.candidateSource = candidateSource;
    }

    @Override
    protected void initializeProvider(InterceptorProvider provider, Bus bus) {
        
    }
    
    
}

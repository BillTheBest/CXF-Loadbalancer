package org.apache.cxf.loadbalancer;

import java.util.List;
import java.util.Random;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.loadbalancer.spi.EndpointSelectionStrategy;

public class RandomEndpointSelectionStrategy implements EndpointSelectionStrategy {
    private Random random;
    private boolean stayWithEndpoint;
    private Endpoint currentEndpoint;

    public RandomEndpointSelectionStrategy(boolean stayWithEndpoint) {
        this.random = new Random();
        this.stayWithEndpoint = stayWithEndpoint;
    }

    public Endpoint selectEndpoint(List<Endpoint> candidates) {
        // Invalidate current endpoint if it is not a candidate anymore
        if (stayWithEndpoint && currentEndpoint != null) {
            if (!candidates.contains(currentEndpoint)) {
                currentEndpoint = null;
            }
        }

        // Select a new endpoint randomly from the candidates list
        if (!stayWithEndpoint || currentEndpoint == null) {
            int selected = random.nextInt(candidates.size());
            currentEndpoint = candidates.get(selected);
        }
        return currentEndpoint;
    }
    
}

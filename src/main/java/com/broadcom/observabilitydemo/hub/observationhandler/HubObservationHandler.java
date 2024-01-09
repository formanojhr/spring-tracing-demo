package com.broadcom.observabilitydemo.hub.observationhandler;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manoj Ramakrishnan (rmanoj@vmware.com).
 * @since 1/4/24 6:43 PM
 */
public class HubObservationHandler implements ObservationHandler<Observation.Context> {
    private Logger log  = LoggerFactory.getLogger(HubObservationHandler.class);
    @Override
    public boolean supportsContext(Observation.Context context) {
        return false;
    }


    @Override
    public void onStart(Observation.Context context) {
        log.info("context name {}", context.getName());
    }
}

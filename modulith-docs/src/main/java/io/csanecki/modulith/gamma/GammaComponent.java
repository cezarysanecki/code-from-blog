package io.csanecki.modulith.gamma;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class GammaComponent {

    private static final String GAMMA = "gamma";

    private final ApplicationEventPublisher applicationEventPublisher;

    public GammaComponent(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void callAll() {
        applicationEventPublisher.publishEvent(new GammaEvent());
    }

    public void doSomething(String component) {
        System.out.println("calling gamma from " + component);
    }
}

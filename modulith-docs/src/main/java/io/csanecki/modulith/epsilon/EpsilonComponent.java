package io.csanecki.modulith.epsilon;

import io.csanecki.modulith.gamma.GammaEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EpsilonComponent {

    private static final String EPSILON = "epsilon";

    @EventListener
    public void handle(GammaEvent event) {
        System.out.println("caught gamma event in " + EPSILON);
    }

    public void doSomething(String component) {
        System.out.println("calling epsilon from " + component);
    }
}

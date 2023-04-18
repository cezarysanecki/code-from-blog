package io.csanecki.modulith.beta;

import io.csanecki.modulith.alfa.AlfaEvent;
import io.csanecki.modulith.delta.DeltaComponent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BetaComponent {

    private static final String BETA = "beta";

    private final DeltaComponent deltaComponent;

    public BetaComponent(DeltaComponent deltaComponent) {
        this.deltaComponent = deltaComponent;
    }

    @EventListener
    public void handle(AlfaEvent event) {
        System.out.println("caught alfa event in " + BETA);
    }

    public void callAll() {
        deltaComponent.doSomething(BETA);
    }

    public void doSomething(String component) {
        System.out.println("calling beta from " + component);
    }
}

package io.csanecki.modulith.delta;

import io.csanecki.modulith.alfa.AlfaEvent;
import io.csanecki.modulith.gamma.GammaComponent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DeltaComponent {

    private static final String DELTA = "delta";

    private final GammaComponent gammaComponent;

    public DeltaComponent(GammaComponent gammaComponent) {
        this.gammaComponent = gammaComponent;
    }

    @EventListener
    public void handle(AlfaEvent event) {
        System.out.println("caught alfa event in " + DELTA);
    }

    public void callAll() {
        gammaComponent.doSomething(DELTA);
    }

    public void doSomething(String component) {
        System.out.println("calling delta from " + component);
    }
}

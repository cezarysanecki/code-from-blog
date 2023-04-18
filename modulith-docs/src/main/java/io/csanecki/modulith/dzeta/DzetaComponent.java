package io.csanecki.modulith.dzeta;

import io.csanecki.modulith.epsilon.EpsilonComponent;
import io.csanecki.modulith.gamma.GammaEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DzetaComponent {

    private static final String DZETA = "dzeta";

    private final EpsilonComponent epsilonComponent;

    public DzetaComponent(EpsilonComponent epsilonComponent) {
        this.epsilonComponent = epsilonComponent;
    }

    @EventListener
    public void handle(GammaEvent event) {
        System.out.println("caught gamma event in " + DZETA);
    }

    public void callAll() {
        epsilonComponent.doSomething(DZETA);
    }

    public void doSomething(String component) {
        System.out.println("calling dzeta from " + component);
    }
}

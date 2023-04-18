package io.csanecki.modulith.alfa;

import io.csanecki.modulith.dzeta.DzetaComponent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AlfaComponent {

    private static final String ALFA = "alfa";

    private final ApplicationEventPublisher applicationEventPublisher;
    private final DzetaComponent dzetaComponent;

    public AlfaComponent(
        ApplicationEventPublisher applicationEventPublisher,
        DzetaComponent dzetaComponent) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.dzetaComponent = dzetaComponent;
    }

    public void callAll() {
        dzetaComponent.doSomething(ALFA);
        applicationEventPublisher.publishEvent(new AlfaEvent());
    }

    public void doSomething(String component) {
        System.out.println("calling alfa from " + component);
    }
}

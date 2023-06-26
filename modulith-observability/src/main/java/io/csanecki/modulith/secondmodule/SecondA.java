package io.csanecki.modulith.secondmodule;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SecondA {

    private final ApplicationEventPublisher publisher;

    SecondA(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void doSomething() {
        publisher.publishEvent(new SecondModuleEvent("second module rulz!"));
    }

}

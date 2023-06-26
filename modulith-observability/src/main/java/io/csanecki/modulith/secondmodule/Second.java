package io.csanecki.modulith.secondmodule;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Second {

    private final ApplicationEventPublisher publisher;

    Second(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void doSomething() {
        publisher.publishEvent(new SecondModuleEvent("second module rulz!"));
    }

}

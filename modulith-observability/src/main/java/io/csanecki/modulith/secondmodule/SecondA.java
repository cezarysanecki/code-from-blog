package io.csanecki.modulith.secondmodule;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

public class SecondA {

    private final ApplicationEventPublisher publisher;

    SecondA(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Transactional
    public void doSomething() {
        publisher.publishEvent(new SecondModuleEvent());
    }

}

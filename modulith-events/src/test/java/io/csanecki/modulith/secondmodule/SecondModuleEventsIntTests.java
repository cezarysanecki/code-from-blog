package io.csanecki.modulith.secondmodule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.AssertablePublishedEvents;
import org.springframework.modulith.test.PublishedEvents;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class SecondModuleEventsIntTests {

    @Autowired
    private SecondA secondA;

    @Test
    void emit_event_exactly_once(PublishedEvents events) {
        secondA.doSomething();

        var secondModuleEvents = events.ofType(SecondModuleEvent.class);
        assertThat(secondModuleEvents).hasSize(1);
    }

    @Test
    void event_is_emitted_at_least_once(AssertablePublishedEvents events) {
        secondA.doSomething();

        events.assertThat()
            .contains(SecondModuleEvent.class);
    }

}

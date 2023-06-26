package io.csanecki.modulith.firstmodule;

import io.csanecki.modulith.secondmodule.SecondA;
import io.csanecki.modulith.secondmodule.SecondModuleEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.events.EventPublicationRepository;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.ApplicationModuleTest.BootstrapMode;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest(value = BootstrapMode.ALL_DEPENDENCIES)
class BetweenModulesEventsIntTests {

    @Autowired
    private SecondA secondA;

    @Autowired
    private EventPublicationRepository eventPublicationRepository;

    @Test
    void emit_event_exactly_once() {
        secondA.doSomething();

        var result = eventPublicationRepository.findIncompletePublications();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getEvent()).isInstanceOf(SecondModuleEvent.class);
    }

}

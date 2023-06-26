package io.csanecki.modulith.firstmodule;

import io.csanecki.modulith.secondmodule.SecondModuleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FirstA {

    private static final Logger log = LoggerFactory.getLogger(FirstA.class);

    @EventListener
    public void handle(SecondModuleEvent event) {
        log.info("got message from second module: " + event.message());
    }
}

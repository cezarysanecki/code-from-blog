package io.csanecki.modulith.firstmodule;

import io.csanecki.modulith.secondmodule.SecondModuleEvent;
import io.csanecki.modulith.thirdmodule.Third;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class First {

    private static final Log logger = LogFactory.getLog(First.class);

    @Autowired
    private Third third;

    @EventListener
    public void handle(SecondModuleEvent event) {
        logger.info("got message from second module in first module: " + event.message());
        third.callFrom("first");
    }
}

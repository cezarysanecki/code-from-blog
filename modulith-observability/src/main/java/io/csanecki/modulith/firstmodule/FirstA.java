package io.csanecki.modulith.firstmodule;

import io.csanecki.modulith.secondmodule.SecondModuleEvent;
import io.csanecki.modulith.thirdmodule.ThirdA;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FirstA {

    private static final Log logger = LogFactory.getLog(FirstA.class);

    @Autowired
    private ThirdA thirdA;

    @EventListener
    public void handle(SecondModuleEvent event) {
        logger.info("got message from second module: " + event.message());
        thirdA.callMe();
    }
}

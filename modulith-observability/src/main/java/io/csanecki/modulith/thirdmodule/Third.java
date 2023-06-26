package io.csanecki.modulith.thirdmodule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class Third {

    private static final Log logger = LogFactory.getLog(Third.class);

    public void callFrom(String module) {
        logger.info("called third module from: " + module);
    }
}

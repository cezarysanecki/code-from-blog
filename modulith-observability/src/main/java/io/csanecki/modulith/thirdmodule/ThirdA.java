package io.csanecki.modulith.thirdmodule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ThirdA {

    private static final Log logger = LogFactory.getLog(ThirdA.class);

    public void callMe() {
        logger.info("call me!");
    }
}

package io.csanecki.modulith.firstmodule;

import io.csanecki.modulith.secondmodule.SecondModuleEvent;
import org.springframework.stereotype.Component;

@Component
public class FirstA {

    public void handle(SecondModuleEvent event) {
        System.out.println("i've got message!");
        throw new IllegalStateException("something went wrong!");
    }
}

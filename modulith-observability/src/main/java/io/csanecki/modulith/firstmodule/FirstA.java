package io.csanecki.modulith.firstmodule;

import io.csanecki.modulith.firstmodule.internal.FirstInternalA;
import io.csanecki.modulith.secondmodule.SecondB;
import io.csanecki.modulith.secondmodule.SecondModuleEvent;
import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class FirstA {

    private final FirstInternalA firstInternalA;
    private final SecondB secondB; // artificial dependency

    FirstA(FirstInternalA firstInternalA, SecondB secondB) {
        this.firstInternalA = firstInternalA;
        this.secondB = secondB;
    }

    @ApplicationModuleListener
    public void handle(SecondModuleEvent event) {
        System.out.println("i've got message!");
        throw new IllegalStateException("something went wrong!");
    }
}

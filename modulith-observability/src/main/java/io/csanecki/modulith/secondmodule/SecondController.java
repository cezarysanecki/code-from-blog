package io.csanecki.modulith.secondmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    @Autowired
    Second second;

    @GetMapping("/fire")
    void fire() {
        second.doSomething();
    }

}

package io.csanecki.modulith;

import io.csanecki.modulith.secondmodule.Second;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ModulithEventsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModulithEventsDemoApplication.class, args);
    }

    @Autowired
    Second second;

    @Bean
    CommandLineRunner init() {
        return args -> second.doSomething();
    }

}

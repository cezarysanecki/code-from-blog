package io.csanecki.missingtransactional;

import io.csanecki.missingtransactional.cache.WithoutExceptionExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MissingTransactionalApplication {

  public static void main(String[] args) {
    SpringApplication.run(MissingTransactionalApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(WithoutExceptionExecutor withoutExceptionExecutor) {
    return args -> withoutExceptionExecutor.execute();
  }

}

package io.csanecki.modulith.secondmodule;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConfig {

  private final ApplicationEventPublisher publisher;

  SecondConfig(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  @Bean
  SecondA secondA() {
    return new SecondA(publisher);
  }

  @Bean
  SecondB secondB() {
    SecondInternalC secondInternalC = new SecondInternalC();
    return new SecondB(secondInternalC);
  }
}

package pl.csanecki.modulith.secondmodule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.csanecki.modulith.firstmodule.FirstA;

@Configuration
public class SecondConfig {

  private final FirstA firstA;

  SecondConfig(FirstA firstA) {
    this.firstA = firstA;
  }

  @Bean
  SecondA secondA() {
    return new SecondA(firstA);
  }

  @Bean
  SecondB secondB() {
    SecondInternalC secondInternalC = new SecondInternalC();
    return new SecondB(secondInternalC);
  }
}

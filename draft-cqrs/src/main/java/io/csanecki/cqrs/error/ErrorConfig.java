package io.csanecki.cqrs.error;

import io.csanecki.cqrs.error.api.ErrorSaver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ErrorConfig {

  private final ErrorRepository errorRepository;

  @Bean
  ErrorSaver errorSaver() {
    return new ErrorSaveHandler(errorRepository);
  }

  @Bean
  ErrorQueryRepository errorQueryRepository() {
    return new ErrorQueryRepository(errorRepository);
  }

}

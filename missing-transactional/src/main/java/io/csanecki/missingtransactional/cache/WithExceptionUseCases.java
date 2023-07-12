package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntityOperations;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class WithExceptionUseCases {

  private final ExampleEntityOperations useCases;

  public WithExceptionUseCases(ExampleEntityOperations useCases) {
    this.useCases = useCases;
  }

  public Long withoutTransactional() {
    Long id = useCases.create();
    useCases.updateFirstField(id, "first");
    useCases.updateSecondFieldWithException(id, "second");
    return id;
  }

  @Transactional
  public Long withTransactional() {
    Long id = useCases.create();
    useCases.updateFirstField(id, "first");
    useCases.updateSecondFieldWithException(id, "second");
    return id;
  }

}

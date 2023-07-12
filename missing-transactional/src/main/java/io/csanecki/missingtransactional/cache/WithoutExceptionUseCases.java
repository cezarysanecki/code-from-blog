package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntityOperations;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class WithoutExceptionUseCases {

  private final ExampleEntityOperations useCases;

  public WithoutExceptionUseCases(ExampleEntityOperations useCases) {
    this.useCases = useCases;
  }

  public Long withoutTransactional() {
    Long id = useCases.create();
    useCases.updateFirstField(id, "first");
    useCases.updateSecondField(id, "second");
    return id;
  }

  @Transactional
  public Long withTransactional() {
    Long id = useCases.create();
    useCases.updateFirstField(id, "first");
    useCases.updateSecondField(id, "second");
    return id;
  }

}
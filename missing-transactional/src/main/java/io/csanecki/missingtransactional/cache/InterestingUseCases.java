package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
import io.csanecki.missingtransactional.utils.RuntimeExceptionWIthId;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class InterestingUseCases {

  private final ExampleEntityRepository exampleEntityRepository;

  public InterestingUseCases(ExampleEntityRepository exampleEntityRepository) {
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public Long withoutTransactionalWithTry() {
    try {
      return useCase();
    } catch (RuntimeExceptionWIthId exception) {
      return exception.getId();
    }
  }

  @Transactional
  public Long withTransactionalWithTry() {
    try {
      return useCase();
    } catch (RuntimeExceptionWIthId exception) {
      return exception.getId();
    }
  }

  public Long withoutTransactionalWithoutTry() {
    return useCase();
  }

  @Transactional
  public Long withTransactionalWithoutTry() {
    return useCase();
  }

  private Long useCase() {
    ExampleEntity exampleEntity = exampleEntityRepository.save(new ExampleEntity());
    Long id = exampleEntity.getId();

    exampleEntity.setFirstFieldWithRuntimeException(id, "first");
    exampleEntity.setSecondField("second");

    return id;
  }

}

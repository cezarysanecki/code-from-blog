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

  public Long create() {
    return exampleEntityRepository.save(new ExampleEntity())
        .getId();
  }

  public Long withoutTransactional() {
    return useCase();
  }

  @Transactional
  public Long withTransactional() {
    return useCase();
  }

  private Long useCase() {
    Long id = null;
    try {
      ExampleEntity exampleEntity = exampleEntityRepository.save(new ExampleEntity());
      id = exampleEntity.getId();

      exampleEntity.setFirstFieldWithRuntimeException(id, "first");
      exampleEntity = exampleEntityRepository.save(exampleEntity);
      exampleEntity.setSecondField("second");
    } catch (RuntimeExceptionWIthId ignored) {

    }
    return id;
  }

}

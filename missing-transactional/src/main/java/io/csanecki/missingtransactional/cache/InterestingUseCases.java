package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
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

  public void withoutTransactional(Long id) {
    useCase(id);
  }

  @Transactional
  public void withTransactional(Long id) {
    useCase(id);
  }

  private void useCase(Long id) {
    ExampleEntity exampleEntity = exampleEntityRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("cannot find entity for: " + id));

    exampleEntity.setFirstFieldWithRuntimeException(id, "first");
    exampleEntity = exampleEntityRepository.save(exampleEntity);
    exampleEntity.setSecondField("second");
  }

}

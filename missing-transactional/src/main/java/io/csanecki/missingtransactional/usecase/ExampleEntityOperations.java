package io.csanecki.missingtransactional.usecase;

import org.springframework.stereotype.Component;

@Component
public class ExampleEntityOperations {

  private final ExampleEntityRepository exampleEntityRepository;

  public ExampleEntityOperations(ExampleEntityRepository exampleEntityRepository) {
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public Long create() {
    return exampleEntityRepository.save(new ExampleEntity()).getId();
  }

  public void updateFirstField(Long id, String field) {
    exampleEntityRepository.findById(id)
        .ifPresent(exampleEntity -> exampleEntity.setFirstField(field));
  }

  public void updateSecondField(Long id, String field) {
    exampleEntityRepository.findById(id)
        .ifPresent(exampleEntity -> exampleEntity.setSecondField(field));
  }

  public void updateSecondFieldWithException(Long id, String field) {
    exampleEntityRepository.findById(id)
        .ifPresent(exampleEntity -> exampleEntity.setSecondFieldWithRuntimeException(id, field));
  }

}

package io.csanecki.missingtransactional;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;

public class ExampleEntityUseCases {

  private final ExampleEntityRepository exampleEntityRepository;

  public ExampleEntityUseCases(ExampleEntityRepository exampleEntityRepository) {
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public Long create() {
    return exampleEntityRepository.save(new ExampleEntity()).getId();
  }

  public void updateFirstField(Long id, String field) {
    exampleEntityRepository.findById(id)
        .ifPresent(exampleEntity -> exampleEntity.setFirstField(field));
  }

  public void updateFirstFieldWithException(Long id, String field) {
    exampleEntityRepository.findById(id)
        .ifPresent(exampleEntity -> exampleEntity.setFirstFieldWithRuntimeException(field));
  }

  public void updateSecondField(Long id, String field) {
    exampleEntityRepository.findById(id)
        .ifPresent(exampleEntity -> exampleEntity.setFirstField(field));
  }

}

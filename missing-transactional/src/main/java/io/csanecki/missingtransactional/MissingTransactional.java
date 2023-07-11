package io.csanecki.missingtransactional;

import org.springframework.stereotype.Service;

@Service
public class MissingTransactional {

  private final ExampleEntityRepository exampleEntityRepository;

  public MissingTransactional(ExampleEntityRepository exampleEntityRepository) {
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public Long create() {
    return exampleEntityRepository.save(new ExampleEntity())
        .getId();
  }

  public void updateTwoSaves(Long id, String firstField, String secondField) {
    ExampleEntity exampleEntity = exampleEntityRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("cannot find entity by id: " + id));

    exampleEntity.setFirstField(firstField);
    exampleEntity = exampleEntityRepository.save(exampleEntity);

    exampleEntity.setSecondField(secondField);
    exampleEntityRepository.save(exampleEntity);
  }

  public void updateOneSave(Long id, String firstField, String secondField) {
    ExampleEntity exampleEntity = exampleEntityRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("cannot find entity by id: " + id));

    exampleEntity.setFirstField(firstField);
    exampleEntity.setSecondField(secondField);

    exampleEntityRepository.save(exampleEntity);
  }

  public void updateWithoutSave(Long id, String firstField, String secondField) {
    ExampleEntity exampleEntity = exampleEntityRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("cannot find entity by id: " + id));

    exampleEntity.setFirstField(firstField);
    exampleEntity.setSecondField(secondField);
  }

}

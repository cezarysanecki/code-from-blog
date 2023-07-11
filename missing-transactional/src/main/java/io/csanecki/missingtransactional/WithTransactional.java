package io.csanecki.missingtransactional;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WithTransactional {

  private final ExampleEntityRepository exampleEntityRepository;

  public WithTransactional(ExampleEntityRepository exampleEntityRepository) {
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public Long create() {
    return exampleEntityRepository.save(new ExampleEntity())
        .getId();
  }

  @Transactional
  public void updateTwoSaves(Long id, String firstField, String secondField) {
    ExampleEntity exampleEntity = exampleEntityRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("cannot find entity by id: " + id));

    exampleEntity.setFirstField(firstField);
    exampleEntity = exampleEntityRepository.save(exampleEntity);

    exampleEntity.setSecondField(secondField);
    exampleEntityRepository.save(exampleEntity);
  }

  @Transactional
  public void updateOneSave(Long id, String firstField, String secondField) {
    ExampleEntity exampleEntity = exampleEntityRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("cannot find entity by id: " + id));

    exampleEntity.setFirstField(firstField);
    exampleEntity.setSecondField(secondField);

    exampleEntityRepository.save(exampleEntity);
  }

  @Transactional
  public void updateWithoutSave(Long id, String firstField, String secondField) {
    ExampleEntity exampleEntity = exampleEntityRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("cannot find entity by id: " + id));

    exampleEntity.setFirstField(firstField);
    exampleEntity.setSecondField(secondField);
  }

}

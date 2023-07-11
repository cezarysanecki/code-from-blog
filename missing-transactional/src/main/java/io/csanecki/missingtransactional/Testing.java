package io.csanecki.missingtransactional;

import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class Testing {

  private final MissingTransactional missingTransactional;
  private final WithTransactional withTransactional;
  private final ExampleEntityRepository exampleEntityRepository;

  public Testing(
      MissingTransactional missingTransactional,
      WithTransactional withTransactional,
      ExampleEntityRepository exampleEntityRepository
  ) {
    this.missingTransactional = missingTransactional;
    this.withTransactional = withTransactional;
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public void test() {
    System.out.println("WITHOUT TRANSACTION");

    useCase("missing transactional - two saves",
        id -> missingTransactional.updateTwoSaves(id, "1-1", "1-2"));
    System.out.println();
    useCase("missing transactional - one save",
        id -> missingTransactional.updateOneSave(id, "2-1", "2-2"));
    System.out.println();
    useCase("missing transactional - zero saves",
        id -> missingTransactional.updateWithoutSave(id, "3-1", "3-2"));
    System.out.println();

    System.out.println("WITH TRANSACTION");

    useCase("with transactional - two saves",
        id -> withTransactional.updateTwoSaves(id, "1-1", "1-2"));
    System.out.println();
    useCase("with transactional - one save",
        id -> withTransactional.updateOneSave(id, "2-1", "2-2"));
    System.out.println();
    useCase("with transactional - zero saves",
        id -> withTransactional.updateWithoutSave(id, "3-1", "3-2"));
    System.out.println();
  }

  private void useCase(String testCase, Consumer<Long> update) {
    Long entityId = missingTransactional.create();
    System.out.println("=== " + testCase + " ===");
    try {
      update.accept(entityId);
      missingTransactional.updateTwoSaves(entityId, "1-1", "1-2");
    } catch (Exception exception) {
      System.out.println("!!! there is exception !!!");
    } finally {
      exampleEntityRepository.findById(entityId)
          .ifPresentOrElse(
              exampleEntity -> {
                System.out.println("found entity for: " + entityId);
                System.out.println(exampleEntity.getFirstField());
                System.out.println(exampleEntity.getSecondField());
              },
              () -> System.out.println("missing entity for: " + entityId)
          );
    }
  }

}

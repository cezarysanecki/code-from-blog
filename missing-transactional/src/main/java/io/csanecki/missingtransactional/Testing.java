package io.csanecki.missingtransactional;

import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
import io.csanecki.missingtransactional.usecase.UseCases;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class Testing {

  private final UseCases useCases;
  private final ExampleEntityRepository exampleEntityRepository;

  public Testing(
      UseCases useCases,
      ExampleEntityRepository exampleEntityRepository
  ) {
    this.useCases = useCases;
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public void withoutTransaction(String testCase, Consumer<Long> update) {
    System.out.println("WITHOUT TRANSACTION");
    useCase(testCase, update);
  }

  @Transactional
  public void withTransaction(String testCase, Consumer<Long> update) {
    System.out.println("WITH TRANSACTION");
    useCase(testCase, update);
  }

  private void useCase(String testCase, Consumer<Long> update) {
    Long entityId = null;
    try {
      System.out.println("=== " + testCase + " ===");
      entityId = useCases.create();
      update.accept(entityId);
    } finally {
      if (entityId == null) {
        System.out.println("failed even saving");
      } else {
        Long finalEntityId = entityId;

        exampleEntityRepository.findById(finalEntityId)
            .ifPresentOrElse(
                exampleEntity -> {
                  System.out.println("found entity for: " + finalEntityId);
                  System.out.println(exampleEntity.getFirstField());
                  System.out.println(exampleEntity.getSecondField());
                },
                () -> System.out.println("missing entity for: " + finalEntityId)
            );
      }
    }
  }

}

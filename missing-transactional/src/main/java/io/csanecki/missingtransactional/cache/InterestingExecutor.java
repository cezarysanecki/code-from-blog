package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
import io.csanecki.missingtransactional.utils.RuntimeExceptionWIthId;
import org.springframework.stereotype.Component;

@Component
public class InterestingExecutor {

  private final InterestingUseCases interestingUseCases;
  private final ExampleEntityRepository exampleEntityRepository;

  public InterestingExecutor(
      InterestingUseCases interestingUseCases,
      ExampleEntityRepository exampleEntityRepository
  ) {
    this.interestingUseCases = interestingUseCases;
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public void executeWithoutTry() {
    System.out.println("-> WITHOUT TRANSACTION <-");
    Long firstId = interestingUseCases.withoutTransactionalWithTry();
    System.out.println("=== VERIFICATION ===");
    if (firstId == null) {
      System.out.println("no saved item");
    } else {
      exampleEntityRepository.findById(firstId)
          .map(ExampleEntity::toString)
          .ifPresent(System.out::println);
    }

    System.out.println("====");

    System.out.println("-> WITH TRANSACTION <-");
    Long secondId = interestingUseCases.withTransactionalWithTry();
    System.out.println("=== VERIFICATION ===");
    if (secondId == null) {
      System.out.println("no saved item");
    } else {
      exampleEntityRepository.findById(secondId)
          .map(ExampleEntity::toString)
          .ifPresent(System.out::println);
    }
  }

  public void executeWithTry() {
    System.out.println("-> WITHOUT TRANSACTION <-");
    try {
      interestingUseCases.withoutTransactionalWithoutTry();
    } catch (RuntimeExceptionWIthId exception) {
      System.out.println("=== VERIFICATION ===");
      Long id = exception.getId();
      if (id == null) {
        System.out.println("no saved item");
      } else {
        exampleEntityRepository.findById(id)
            .map(ExampleEntity::toString)
            .ifPresent(System.out::println);
      }
    }

    System.out.println("====");

    System.out.println("-> WITH TRANSACTION <-");
    try {
      interestingUseCases.withTransactionalWithoutTry();
    } catch (RuntimeExceptionWIthId exception) {
      System.out.println("=== VERIFICATION ===");
      Long id = exception.getId();
      if (id == null) {
        System.out.println("no saved item");
      } else {
        exampleEntityRepository.findById(id)
            .map(ExampleEntity::toString)
            .ifPresent(System.out::println);
      }
    }
  }

}

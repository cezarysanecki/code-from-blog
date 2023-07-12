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

  public void execute() {
    System.out.println("-> WITHOUT TRANSACTION <-");
    Long firstId = interestingUseCases.create();
    try {
      interestingUseCases.withoutTransactional(firstId);
    } catch (RuntimeExceptionWIthId exception) {
      System.out.println("*** VERIFICATION ***");
      Long id = exception.getId();
      if (id == null) {
        System.out.println("no saved item");
      } else {
        exampleEntityRepository.findById(id).map(ExampleEntity::toString).ifPresent(System.out::println);
      }
    }

    System.out.println("====");

    System.out.println("-> WITH TRANSACTION <-");
    Long secondId = interestingUseCases.create();
    try {
      interestingUseCases.withTransactional(secondId);
    } catch (RuntimeExceptionWIthId exception) {
      System.out.println("*** VERIFICATION ***");
      Long id = exception.getId();
      if (id == null) {
        System.out.println("no saved item");
      } else {
        exampleEntityRepository.findById(id).map(ExampleEntity::toString).ifPresent(System.out::println);
      }
    }
  }

}

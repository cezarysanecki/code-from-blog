package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class InterestingExecutor {

  private final InterestingUseCases interestingUseCases;
  private final ExampleEntityRepository exampleEntityRepository;

  public InterestingExecutor(InterestingUseCases interestingUseCases, ExampleEntityRepository exampleEntityRepository) {
    this.interestingUseCases = interestingUseCases;
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public void execute() {
    System.out.println("-> WITHOUT TRANSACTION <-");
    Long firstId = interestingUseCases.withoutTransactional();
    System.out.println("*** VERIFICATION ***");
    if (firstId == null) {
      System.out.println("no saved item");
    } else {
      exampleEntityRepository.findById(firstId)
          .map(ExampleEntity::toString)
          .ifPresent(System.out::println);
    }

    System.out.println("====");

    System.out.println("-> WITH TRANSACTION <-");
    Long secondId = interestingUseCases.withTransactional();
    System.out.println("*** VERIFICATION ***");
    if (secondId == null) {
      System.out.println("no saved item");
    } else {
      exampleEntityRepository.findById(secondId)
          .map(ExampleEntity::toString)
          .ifPresent(System.out::println);
    }
  }

}

package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
import io.csanecki.missingtransactional.utils.RuntimeExceptionWIthId;
import org.springframework.stereotype.Component;

@Component
public class WithExceptionExecutor {

  private final WithExceptionUseCases withExceptionUseCases;
  private final ExampleEntityRepository exampleEntityRepository;

  public WithExceptionExecutor(
      WithExceptionUseCases withExceptionUseCases,
      ExampleEntityRepository exampleEntityRepository
  ) {
    this.withExceptionUseCases = withExceptionUseCases;
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public void execute() {
    System.out.println("-> WITHOUT TRANSACTION <-");
    try {
      withExceptionUseCases.withoutTransactional();
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
    try {
      withExceptionUseCases.withTransactional();
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

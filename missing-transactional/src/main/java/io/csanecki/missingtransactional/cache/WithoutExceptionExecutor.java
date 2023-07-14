package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class WithoutExceptionExecutor {

  private final WithoutExceptionUseCases withoutExceptionUseCases;
  private final ExampleEntityRepository exampleEntityRepository;

  public WithoutExceptionExecutor(
      WithoutExceptionUseCases withoutExceptionUseCases,
      ExampleEntityRepository exampleEntityRepository
  ) {
    this.withoutExceptionUseCases = withoutExceptionUseCases;
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public void execute() {
    System.out.println("-> WITHOUT TRANSACTION <-");
    Long withoutTransactionalId = withoutExceptionUseCases.withoutTransactional();
    System.out.println("=== VERIFICATION ===");
    exampleEntityRepository.findById(withoutTransactionalId)
        .map(ExampleEntity::toString)
        .ifPresent(System.out::println);

    System.out.println("====");

    System.out.println("-> WITH TRANSACTION <-");
    Long withTransactionalId = withoutExceptionUseCases
        .withTransactional();
    System.out.println("=== VERIFICATION ===");
    exampleEntityRepository.findById(withTransactionalId)
        .map(ExampleEntity::toString)
        .ifPresent(System.out::println);
  }

}

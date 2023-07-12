package io.csanecki.missingtransactional.cache;

import io.csanecki.missingtransactional.usecase.ExampleEntity;
import io.csanecki.missingtransactional.usecase.ExampleEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class CacheExample {

  private final CacheUseCases cacheUseCases;
  private final ExampleEntityRepository exampleEntityRepository;

  public CacheExample(CacheUseCases cacheUseCases, ExampleEntityRepository exampleEntityRepository) {
    this.cacheUseCases = cacheUseCases;
    this.exampleEntityRepository = exampleEntityRepository;
  }

  public void withoutException() {
    System.out.println("-> WITHOUT TRANSACTION <-");
    Long withoutTransactionalId = cacheUseCases.withoutTransactional();
    System.out.println("*** VERIFICATION ***");
    exampleEntityRepository.findById(withoutTransactionalId).map(ExampleEntity::toString).ifPresent(System.out::println);

    System.out.println("====");

    System.out.println("-> WITH TRANSACTION <-");
    Long withTransactionalId = cacheUseCases.withTransactional();
    System.out.println("*** VERIFICATION ***");
    exampleEntityRepository.findById(withTransactionalId).map(ExampleEntity::toString).ifPresent(System.out::println);
  }

}

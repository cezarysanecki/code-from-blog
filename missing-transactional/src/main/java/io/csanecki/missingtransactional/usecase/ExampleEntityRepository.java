package io.csanecki.missingtransactional.usecase;

import org.springframework.data.repository.CrudRepository;

public interface ExampleEntityRepository extends CrudRepository<ExampleEntity, Long> {
}

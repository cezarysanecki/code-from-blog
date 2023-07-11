package io.csanecki.missingtransactional;

import org.springframework.data.repository.CrudRepository;

public interface ExampleEntityRepository extends CrudRepository<ExampleEntity, Long> {
}

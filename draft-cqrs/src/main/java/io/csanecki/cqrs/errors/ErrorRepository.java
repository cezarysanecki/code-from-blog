package io.csanecki.cqrs.errors;

import org.springframework.data.repository.CrudRepository;

interface ErrorRepository extends CrudRepository<DraftError, Long> {
}

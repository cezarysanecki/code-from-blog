package io.csanecki.cqrs.draft;

import org.springframework.data.repository.CrudRepository;

interface DraftRepository extends CrudRepository<Draft, Long> {

}

package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.DraftId;
import org.springframework.data.repository.CrudRepository;

interface ErrorRepository extends CrudRepository<DraftError, Long> {

  void deleteAllByDraftId(DraftId draftId);

}

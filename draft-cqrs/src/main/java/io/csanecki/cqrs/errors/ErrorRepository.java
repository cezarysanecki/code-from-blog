package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

interface ErrorRepository extends CrudRepository<DraftError, Long> {

  void deleteAllByDraftId(
      @NonNull DraftId draftId
  );

}

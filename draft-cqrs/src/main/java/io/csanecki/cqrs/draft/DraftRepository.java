package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.api.DraftNotFoundException;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface DraftRepository extends CrudRepository<Draft, Long> {

  default Optional<Draft> findByDraftId(@NonNull DraftId draftId) {
    return findById(draftId.toLong());
  }

  default Draft findByDraftIdForce(@NonNull DraftId draftId) {
    return findByDraftId(draftId)
        .orElseThrow(() -> new DraftNotFoundException(draftId));
  }

}

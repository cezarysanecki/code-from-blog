package io.csanecki.draft.draft;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.draft.api.DraftNotFoundException;
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

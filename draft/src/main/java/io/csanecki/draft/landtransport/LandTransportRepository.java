package io.csanecki.draft.landtransport;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.landtransport.api.LandTransportNotFoundException;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface LandTransportRepository extends CrudRepository<LandTransport, Long> {

  Optional<LandTransport> findByDraftId(
      @NonNull DraftId draftId
  );

  default LandTransport findByDraftIdForce(
      @NonNull DraftId draftId
  ) {
    return findByDraftId(draftId)
        .orElseThrow(() -> new LandTransportNotFoundException(draftId));
  }

}

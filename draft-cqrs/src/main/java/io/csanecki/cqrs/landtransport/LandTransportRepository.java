package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.landtransport.api.LandTransportNotFoundException;
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

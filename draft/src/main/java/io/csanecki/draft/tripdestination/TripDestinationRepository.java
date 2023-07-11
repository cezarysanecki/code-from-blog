package io.csanecki.draft.tripdestination;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.tripdestination.api.TripDestinationNotFoundException;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface TripDestinationRepository extends CrudRepository<TripDestination, Long> {

  Optional<TripDestination> findByDraftId(
      @NonNull DraftId draftId
  );

  default TripDestination findByDraftIdForce(
      @NonNull DraftId draftId
  ) {
    return findByDraftId(draftId)
        .orElseThrow(() -> new TripDestinationNotFoundException(draftId));
  }

}

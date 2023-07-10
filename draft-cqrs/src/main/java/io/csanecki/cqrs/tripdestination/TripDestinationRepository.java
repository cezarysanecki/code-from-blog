package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.tripdestination.api.TripDestinationNotFoundException;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResource;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResourceProjection;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface TripDestinationRepository extends CrudRepository<TripDestination, Long>, TripDestinationResourceProjection {

  Optional<TripDestination> findByDraftId(
      @NonNull DraftId draftId
  );

  default TripDestination findByDraftIdForce(
      @NonNull DraftId draftId
  ) {
    return findByDraftId(draftId)
        .orElseThrow(() -> new TripDestinationNotFoundException(draftId));
  }

  @Override
  @Query("""
      SELECT new io.csanecki.cqrs.tripdestination.web.TripDestinationResource(td.draftId, td.destination)
      FROM TripDestination td
      WHERE td.draftId = :draftId
      """)
  TripDestinationResource findProjectionByDraftId(@NonNull DraftId draftId);

}

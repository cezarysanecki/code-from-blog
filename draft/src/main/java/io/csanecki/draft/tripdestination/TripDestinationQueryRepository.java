package io.csanecki.draft.tripdestination;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.landtransport.port.TripDestinationForLandTransportQueryPort;
import io.csanecki.draft.tripdestination.web.TripDestinationResource;
import io.csanecki.draft.tripdestination.web.TripDestinationResourceProjection;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationQueryRepository implements
    TripDestinationForLandTransportQueryPort,
    TripDestinationResourceProjection {

  private final TripDestinationRepository tripDestinationRepository;
  private final EntityManager entityManager;

  @Override
  public boolean containsDestination(@NonNull DraftId draftId) {
    return tripDestinationRepository.findByDraftId(draftId)
        .flatMap(TripDestination::getDestination)
        .isPresent();
  }

  @Override
  public TripDestinationResource findProjectionByDraftId(@NonNull DraftId draftId) {
    return entityManager.createQuery("""
            SELECT new io.csanecki.draft.tripdestination.web.TripDestinationResource(td.destination)
            FROM TripDestination td
            WHERE td.draftId = :draftId
            """, TripDestinationResource.class)
        .setParameter("draftId", draftId)
        .getSingleResult();
  }
}

package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.landtransport.port.TripDestinationForLandTransportQueryPort;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResource;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResourceProjection;
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
            SELECT new io.csanecki.cqrs.tripdestination.web.TripDestinationResource(td.destination)
            FROM TripDestination td
            WHERE td.draftId = :draftId
            """, TripDestinationResource.class)
        .setParameter("draftId", draftId)
        .getSingleResult();
  }
}

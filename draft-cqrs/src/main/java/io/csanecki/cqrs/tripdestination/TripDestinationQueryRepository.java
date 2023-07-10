package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.landtransport.port.TripDestinationForLandTransportQueryPort;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationQueryRepository implements TripDestinationForLandTransportQueryPort {

  private final TripDestinationRepository tripDestinationRepository;

  @Override
  public boolean containsDestination(@NonNull DraftId draftId) {
    return tripDestinationRepository.findByDraftId(draftId)
        .flatMap(TripDestination::getDestination)
        .isPresent();
  }

}

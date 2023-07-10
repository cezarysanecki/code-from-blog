package io.csanecki.cqrs.draft.web;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.landtransport.web.LandTransportResource;
import io.csanecki.cqrs.landtransport.web.LandTransportResourceProjection;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResource;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResourceProjection;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class DraftResourceService {

  private final TripDestinationResourceProjection tripDestinationResourceProjection;
  private final LandTransportResourceProjection landTransportResourceProjection;

  public DraftResource get(
      @NonNull DraftId draftId
  ) {
    TripDestinationResource tripDestination = tripDestinationResourceProjection.findProjectionByDraftId(draftId);
    LandTransportResource landTransport = landTransportResourceProjection.findProjectionByDraftId(draftId);

    return DraftResource.builder()
        .tripDestination(tripDestination)
        .landTransport(landTransport)
        .build();
  }

}

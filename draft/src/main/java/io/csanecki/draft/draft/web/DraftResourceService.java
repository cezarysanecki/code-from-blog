package io.csanecki.draft.draft.web;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.landtransport.web.LandTransportResource;
import io.csanecki.draft.landtransport.web.LandTransportResourceProjection;
import io.csanecki.draft.tripdestination.web.TripDestinationResource;
import io.csanecki.draft.tripdestination.web.TripDestinationResourceProjection;
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
        .draftId(draftId.toLong())
        .tripDestination(tripDestination)
        .landTransport(landTransport)
        .build();
  }

}

package io.csanecki.cqrs.draft.web;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.errors.web.ErrorResource;
import io.csanecki.cqrs.errors.web.ErrorResourceProjection;
import io.csanecki.cqrs.landtransport.web.LandTransportResource;
import io.csanecki.cqrs.landtransport.web.LandTransportResourceProjection;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResource;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResourceProjection;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class DraftResourceService {

  private final TripDestinationResourceProjection tripDestinationResourceProjection;
  private final LandTransportResourceProjection landTransportResourceProjection;
  private final ErrorResourceProjection errorResourceProjection;

  public DraftResource get(
      @NonNull DraftId draftId
  ) {
    TripDestinationResource tripDestination = tripDestinationResourceProjection.findProjectionByDraftId(draftId);
    LandTransportResource landTransport = landTransportResourceProjection.findProjectionByDraftId(draftId);
    Set<ErrorResource> errors = errorResourceProjection.findProjectionAllByDraftId(draftId);

    return DraftResource.builder()
        .draftId(draftId)
        .tripDestination(tripDestination)
        .landTransport(landTransport)
        .errors(errors)
        .build();
  }


}

package io.csanecki.cqrs.tripdestination.web;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

public interface TripDestinationResourceProjection {

  TripDestinationResource findProjectionByDraftId(@NonNull DraftId draftId);

}

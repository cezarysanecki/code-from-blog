package io.csanecki.cqrs.tripdestination.web;

import io.csanecki.cqrs.draft.DraftId;
import lombok.NonNull;

public interface TripDestinationResourceProjection {

  TripDestinationResource findProjectionByDraftId(@NonNull DraftId draftId);

}

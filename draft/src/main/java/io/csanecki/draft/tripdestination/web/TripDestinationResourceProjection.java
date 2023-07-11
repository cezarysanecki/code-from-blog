package io.csanecki.draft.tripdestination.web;

import io.csanecki.draft.draft.api.DraftId;
import lombok.NonNull;

public interface TripDestinationResourceProjection {

  TripDestinationResource findProjectionByDraftId(@NonNull DraftId draftId);

}

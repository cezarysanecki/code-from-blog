package io.csanecki.draft.tripdestination.api;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.section.Section;
import io.csanecki.draft.utils.NotFoundException;
import lombok.NonNull;

public class TripDestinationNotFoundException extends NotFoundException {

  public TripDestinationNotFoundException(@NonNull DraftId draftId) {
    super(draftId, Section.TRIP_DESTINATION);
  }
}

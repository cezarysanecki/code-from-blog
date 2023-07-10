package io.csanecki.cqrs.tripdestination.api;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.section.Section;
import io.csanecki.cqrs.utils.NotFoundException;
import lombok.NonNull;

public class TripDestinationNotFoundException extends NotFoundException {

  public TripDestinationNotFoundException(@NonNull DraftId draftId) {
    super(draftId, Section.TRIP_DESTINATION);
  }
}

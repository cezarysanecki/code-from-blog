package io.csanecki.cqrs.tripdestination.api;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.draft.NotFoundException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class TripDestinationNotFoundException extends NotFoundException {

  @NonNull
  DraftId draftId;

}

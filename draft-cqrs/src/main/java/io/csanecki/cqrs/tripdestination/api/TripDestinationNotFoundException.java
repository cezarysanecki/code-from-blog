package io.csanecki.cqrs.tripdestination.api;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.utils.NotFoundException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class TripDestinationNotFoundException extends NotFoundException {

  @NonNull
  DraftId draftId;

}

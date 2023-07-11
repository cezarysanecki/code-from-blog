package io.csanecki.draft.tripdestination;

import io.csanecki.draft.draft.event.DraftCreated;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationEventListener {

  private final TripDestinationRepository tripDestinationRepository;
  private final TripDestinationFinalValidator tripDestinationFinalValidator;

  @EventListener
  public void handle(
      @NonNull DraftCreated event
  ) {
    TripDestination tripDestination = tripDestinationRepository.save(TripDestination.newOne(event.draftId()));
    tripDestinationFinalValidator.checkForErrors(tripDestination);
  }
}

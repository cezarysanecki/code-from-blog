package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.event.DraftCreated;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationEventListener {

  private final TripDestinationRepository tripDestinationRepository;

  @EventListener
  public void handle(
      @NonNull DraftCreated event
  ) {
    tripDestinationRepository.save(TripDestination.newOne(event.draftId()));
  }
}

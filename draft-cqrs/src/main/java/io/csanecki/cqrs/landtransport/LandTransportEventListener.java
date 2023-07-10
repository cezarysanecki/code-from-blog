package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.event.DraftCreated;
import io.csanecki.cqrs.tripdestination.event.ChangedTripDestination;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class LandTransportEventListener {

  private final LandTransportRepository landTransportRepository;
  private final DefaultFormOfTransportForDestination defaultFormOfTransportForDestination;

  @EventListener
  public void handle(
      @NonNull DraftCreated event
  ) {
    landTransportRepository.save(LandTransport.newOne(event.draftId()));
  }

  @EventListener
  public void handle(
      @NonNull ChangedTripDestination event
  ) {
    LandTransport landTransport = landTransportRepository.findByDraftIdForce(event.draftId());

    landTransport.setFormOfTransport(defaultFormOfTransportForDestination.findFor(event.destination()));
  }

}

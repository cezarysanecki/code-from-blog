package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.event.DraftCreated;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class LandTransportEventListener {

  private final LandTransportRepository landTransportRepository;

  @EventListener
  public void handle(
      @NonNull DraftCreated draftCreated
  ) {
    landTransportRepository.save(LandTransport.newOne(draftCreated.draftId()));
  }
}

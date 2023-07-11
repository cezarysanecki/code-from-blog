package io.csanecki.draft.tripdestination;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.tripdestination.api.Country;
import io.csanecki.draft.tripdestination.command.UpdateDestinationCommand;
import io.csanecki.draft.tripdestination.event.ChangedTripDestination;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TripDestinationFacade {

  private final TripDestinationRepository tripDestinationRepository;
  private final CommandValidator commandValidator;
  private final TripDestinationFinalValidator tripDestinationFinalValidator;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Transactional
  public void updateDestination(
      @NonNull DraftId draftId,
      @NonNull UpdateDestinationCommand command
  ) {
    commandValidator.validate(draftId, command);

    TripDestination tripDestination = tripDestinationRepository.findByDraftIdForce(draftId);
    tripDestination.setDestination(Country.valueOf(command.destination()));
    tripDestinationFinalValidator.checkForErrors(tripDestination);

    applicationEventPublisher.publishEvent(new ChangedTripDestination(draftId, Country.valueOf(command.destination())));
  }

}

package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.tripdestination.command.UpdateDestinationCommand;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TripDestinationFacade {

  private final TripDestinationRepository tripDestinationRepository;
  private final CommandValidator commandValidator;

  @Transactional
  public void updateDestination(
      @NonNull DraftId draftId,
      @NonNull UpdateDestinationCommand command
  ) {
    commandValidator.validate(draftId, command);

    TripDestination tripDestination = tripDestinationRepository.findByDraftIdForce(draftId);
    tripDestination.setDestination(command.destination());
  }

}

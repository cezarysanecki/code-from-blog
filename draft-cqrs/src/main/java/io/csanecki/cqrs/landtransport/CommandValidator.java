package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.draft.DraftValidationException;
import io.csanecki.cqrs.landtransport.port.TripDestinationForLandTransportQueryPort;
import io.csanecki.cqrs.landtransport.command.UpdateFormOfTransportCommand;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CommandValidator {

  private final TripDestinationForLandTransportQueryPort tripDestinationForLandTransportQueryPort;

  void validate(
      @NonNull DraftId draftId,
      @NonNull UpdateFormOfTransportCommand command
  ) {
    boolean containsDestination = tripDestinationForLandTransportQueryPort.containsDestination(draftId);

    checkIfTripDestinationIsEmpty(draftId, containsDestination);
  }

  private void checkIfTripDestinationIsEmpty(
      DraftId draftId,
      boolean containsDestination
  ) {
    if (!containsDestination) {
      throw new DraftValidationException(draftId, LandTransportError.GLOBAL_FORM_OF_TRANSPORT_NEEDS_DESTINATION);
    }
  }

}

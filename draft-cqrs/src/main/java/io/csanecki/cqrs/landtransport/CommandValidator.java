package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.api.DraftValidationException;
import io.csanecki.cqrs.landtransport.command.UpdateFormOfTransportCommand;
import io.csanecki.cqrs.landtransport.port.TripDestinationForLandTransportQueryPort;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CommandValidator {

  private final LandTransportSectionAvailability landTransportSectionAvailability;
  private final TripDestinationForLandTransportQueryPort tripDestinationForLandTransportQueryPort;

  void validate(
      @NonNull DraftId draftId,
      @NonNull UpdateFormOfTransportCommand command
  ) {
    if (!landTransportSectionAvailability.isEditable(draftId)) {
      throw new DraftValidationException(draftId, LandTransportError.GLOBAL_LAND_TRANSPORT_IS_NOT_EDITABLE);
    }

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

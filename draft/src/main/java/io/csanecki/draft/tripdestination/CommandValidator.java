package io.csanecki.draft.tripdestination;

import io.csanecki.draft.dictionary.DraftDictionary;
import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.draft.api.DraftValidationException;
import io.csanecki.draft.tripdestination.command.UpdateDestinationCommand;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CommandValidator {

  private final TripDestinationSectionAvailability tripDestinationSectionAvailability;
  private final DraftDictionary draftDictionary;

  void validate(
      @NonNull DraftId draftId,
      @NonNull UpdateDestinationCommand command
  ) {
    if (!tripDestinationSectionAvailability.isEditable(draftId)) {
      throw new DraftValidationException(draftId, TripDestinationError.GLOBAL_TRIP_DESTINATION_IS_NOT_EDITABLE);
    }
    checkIfDestinationIsPossible(draftId, command.destination());
  }

  private void checkIfDestinationIsPossible(DraftId draftId, String destination) {
    if (draftDictionary.availableCountries()
        .stream()
        .anyMatch(country -> country.name().equals(destination))) {
      return;
    }
    throw new DraftValidationException(draftId, TripDestinationError.LOCAL_DESTINATION_WRONG_VALUE);
  }

}

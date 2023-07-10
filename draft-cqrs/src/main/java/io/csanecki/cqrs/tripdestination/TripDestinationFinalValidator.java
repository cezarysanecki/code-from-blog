package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.error.api.Error;
import io.csanecki.cqrs.error.api.ErrorSaver;
import io.csanecki.cqrs.section.Section;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationFinalValidator {

  private final ErrorSaver errorSaver;

  void checkForErrors(@NonNull TripDestination tripDestination) {
    Set<Error> errors = Stream.of(
            checkIfDestinationIsPresent(tripDestination))
        .flatMap(Optional::stream)
        .collect(Collectors.toUnmodifiableSet());
    errorSaver.clearAndSave(tripDestination.getDraftId(), Section.TRIP_DESTINATION, errors);
  }

  private Optional<Error> checkIfDestinationIsPresent(TripDestination tripDestination) {
    if (tripDestination.getDestination().isPresent()) {
      return Optional.empty();
    }
    return Optional.of(TripDestinationError.LOCAL_DESTINATION_REQUIRED);
  }

}

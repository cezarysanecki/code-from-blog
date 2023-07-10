package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.validation.FinalValidator;
import io.csanecki.cqrs.error.api.Error;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationFinalValidator implements FinalValidator {

  private final TripDestinationRepository tripDestinationRepository;

  @Override
  public Collection<Error> validate(@NonNull DraftId draftId) {
    TripDestination tripDestination = tripDestinationRepository.findByDraftIdForce(draftId);

    return Stream.of(
            checkIfDestinationIsPresent(tripDestination))
        .flatMap(Optional::stream)
        .collect(Collectors.toUnmodifiableSet());
  }

  private Optional<Error> checkIfDestinationIsPresent(TripDestination tripDestination) {
    if (tripDestination.getDestination().isPresent()) {
      return Optional.empty();
    }
    return Optional.of(TripDestinationError.LOCAL_DESTINATION_REQUIRED);
  }

}

package io.csanecki.cqrs.landtransport;

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
class LandTransportFinalValidator implements FinalValidator {

  private final LandTransportRepository landTransportRepository;

  @Override
  public Collection<Error> validate(@NonNull DraftId draftId) {
    LandTransport landTransport = landTransportRepository.findByDraftIdForce(draftId);

    return Stream.of(
            checkIfFormOfTransportIsPresent(landTransport))
        .flatMap(Optional::stream)
        .collect(Collectors.toUnmodifiableSet());
  }

  private Optional<Error> checkIfFormOfTransportIsPresent(LandTransport landTransport) {
    if (landTransport.getFormOfTransport().isPresent()) {
      return Optional.empty();
    }
    return Optional.of(LandTransportError.LOCAL_FORM_OF_TRANSPORT_REQUIRED);
  }

}

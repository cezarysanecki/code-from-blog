package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.error.api.Error;
import io.csanecki.cqrs.error.api.ErrorSaver;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class LandTransportFinalValidator {

  private final ErrorSaver errorSaver;

  public void checkForErrors(@NonNull LandTransport landTransport) {
    Set<Error> errors = Stream.of(
            checkIfFormOfTransportIsPresent(landTransport))
        .flatMap(Optional::stream)
        .collect(Collectors.toUnmodifiableSet());
    errorSaver.clearAndSave(landTransport.getDraftId(), errors);
  }

  private Optional<Error> checkIfFormOfTransportIsPresent(LandTransport landTransport) {
    if (landTransport.getFormOfTransport().isPresent()) {
      return Optional.empty();
    }
    return Optional.of(LandTransportError.LOCAL_FORM_OF_TRANSPORT_REQUIRED);
  }

}

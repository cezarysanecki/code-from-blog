package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.api.DraftValidationException;
import io.csanecki.cqrs.draft.command.ApproveDraftCommand;
import io.csanecki.cqrs.draft.validation.FinalValidator;
import io.csanecki.cqrs.error.api.Error;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CommandValidator {

  private final Collection<FinalValidator> finalValidators;

  void validate(
      @NonNull DraftId draftId,
      @NonNull ApproveDraftCommand command
  ) {
    Set<Error> errors = finalValidators.stream()
        .map(finalValidator -> finalValidator.validate(draftId))
        .flatMap(Collection::stream)
        .collect(Collectors.toUnmodifiableSet());

    if (!errors.isEmpty()) {
      throw new DraftValidationException(draftId, errors);
    }
  }

}

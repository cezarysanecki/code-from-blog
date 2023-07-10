package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.errors.api.Error;
import io.csanecki.cqrs.errors.api.ErrorSaver;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ErrorSaveHandler implements ErrorSaver {

  private final ErrorRepository errorRepository;

  public void clearAndSave(
      @NonNull DraftId draftId,
      @NonNull Collection<Error> errors
  ) {
    errorRepository.deleteAllByDraftId(draftId);

    Set<DraftError> errorsToSave = errors.stream()
        .map(error -> DraftError.from(draftId, error))
        .collect(Collectors.toUnmodifiableSet());

    errorRepository.saveAll(errorsToSave);
  }
}

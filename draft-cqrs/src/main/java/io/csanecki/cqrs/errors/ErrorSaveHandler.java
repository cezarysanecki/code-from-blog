package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.DraftId;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ErrorSaveHandler implements ErrorSaver {

  private final ErrorRepository errorRepository;

  public void clearAndSave(DraftId draftId, Collection<Error> errors) {
    errorRepository.deleteAllByDraftId(draftId);

    Set<DraftError> errorsToSave = errors.stream()
        .map(error -> DraftError.from(draftId, error))
        .collect(Collectors.toUnmodifiableSet());

    errorRepository.saveAll(errorsToSave);
  }
}

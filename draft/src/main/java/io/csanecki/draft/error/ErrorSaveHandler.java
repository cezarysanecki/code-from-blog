package io.csanecki.draft.error;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.error.api.Error;
import io.csanecki.draft.error.api.ErrorSaver;
import io.csanecki.draft.section.Section;
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
      @NonNull Section section,
      @NonNull Collection<Error> errors
  ) {
    errorRepository.deleteAllByDraftIdAndSection(draftId, section);

    Set<DraftError> errorsToSave = errors.stream()
        .map(error -> DraftError.from(draftId, error))
        .collect(Collectors.toUnmodifiableSet());

    errorRepository.saveAll(errorsToSave);
  }
}

package io.csanecki.draft.error;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.draft.port.ErrorForDraftQueryRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ErrorQueryRepository implements ErrorForDraftQueryRepository {

  private final ErrorRepository errorRepository;

  @Override
  public boolean containsErrors(@NonNull DraftId draftId) {
    return errorRepository.countAllByDraftId(draftId) != 0;
  }
}

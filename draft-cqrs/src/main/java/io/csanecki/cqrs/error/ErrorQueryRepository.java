package io.csanecki.cqrs.error;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.port.ErrorForDraftQueryRepository;
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

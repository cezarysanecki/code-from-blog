package io.csanecki.cqrs.utils;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {

  @NonNull
  private final DraftId draftId;

}

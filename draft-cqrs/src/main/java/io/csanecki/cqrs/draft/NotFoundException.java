package io.csanecki.cqrs.draft;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {

  @NonNull
  private final DraftId draftId;

}

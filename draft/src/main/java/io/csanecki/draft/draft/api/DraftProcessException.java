package io.csanecki.draft.draft.api;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class DraftProcessException extends RuntimeException {

  @NonNull
  private final DraftId draftId;

}

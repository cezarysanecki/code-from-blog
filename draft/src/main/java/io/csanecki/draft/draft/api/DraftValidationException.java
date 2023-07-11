package io.csanecki.draft.draft.api;

import io.csanecki.draft.error.api.Error;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class DraftValidationException extends RuntimeException {

  @NonNull
  private final DraftId draftId;

  @NonNull
  private final Error error;

}

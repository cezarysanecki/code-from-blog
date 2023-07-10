package io.csanecki.cqrs.draft.api;

import io.csanecki.cqrs.errors.api.Error;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class DraftValidationException extends RuntimeException {

  @NonNull
  DraftId draftId;

  @NonNull
  Error error;

}

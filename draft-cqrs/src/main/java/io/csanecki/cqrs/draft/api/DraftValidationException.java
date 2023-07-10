package io.csanecki.cqrs.draft.api;

import io.csanecki.cqrs.error.api.Error;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.Collection;
import java.util.Set;

@Getter
@EqualsAndHashCode(callSuper = false)
public class DraftValidationException extends RuntimeException {

  @NonNull
  private final DraftId draftId;

  @NonNull
  private final Collection<Error> errors;

  public DraftValidationException(
      @NonNull DraftId draftId,
      @NonNull Error error
  ) {
    this(draftId, Set.of(error));
  }

  public DraftValidationException(
      @NonNull DraftId draftId,
      @NonNull Collection<Error> errors
  ) {
    this.draftId = draftId;
    this.errors = errors;
  }

}

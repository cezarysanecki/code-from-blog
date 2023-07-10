package io.csanecki.cqrs.errors.api;

import io.csanecki.cqrs.draft.DraftId;
import lombok.NonNull;

import java.util.Collection;

public interface ErrorSaver {

  void clearAndSave(
      @NonNull DraftId draftId,
      @NonNull Collection<Error> errors
  );

}

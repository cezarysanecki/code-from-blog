package io.csanecki.cqrs.error.api;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

import java.util.Collection;

public interface ErrorSaver {

  void clearAndSave(
      @NonNull DraftId draftId,
      @NonNull Collection<Error> errors
  );

}

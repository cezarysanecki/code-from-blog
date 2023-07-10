package io.csanecki.cqrs.error.api;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.section.Section;
import lombok.NonNull;

import java.util.Collection;

public interface ErrorSaver {

  void clearAndSave(
      @NonNull DraftId draftId,
      @NonNull Section section,
      @NonNull Collection<Error> errors
  );

}

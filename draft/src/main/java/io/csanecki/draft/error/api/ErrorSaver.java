package io.csanecki.draft.error.api;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.section.Section;
import lombok.NonNull;

import java.util.Collection;

public interface ErrorSaver {

  void clearAndSave(
      @NonNull DraftId draftId,
      @NonNull Section section,
      @NonNull Collection<Error> errors
  );

}

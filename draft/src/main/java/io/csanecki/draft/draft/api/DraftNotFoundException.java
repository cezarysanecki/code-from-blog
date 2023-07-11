package io.csanecki.draft.draft.api;

import io.csanecki.draft.section.Section;
import io.csanecki.draft.utils.NotFoundException;
import lombok.NonNull;

public class DraftNotFoundException extends NotFoundException {

  public DraftNotFoundException(@NonNull DraftId draftId) {
    super(draftId, Section.ROOT);
  }
}

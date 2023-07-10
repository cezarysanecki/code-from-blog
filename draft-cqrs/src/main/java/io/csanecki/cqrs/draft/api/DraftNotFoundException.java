package io.csanecki.cqrs.draft.api;

import io.csanecki.cqrs.section.Section;
import io.csanecki.cqrs.utils.NotFoundException;
import lombok.NonNull;

public class DraftNotFoundException extends NotFoundException {

  public DraftNotFoundException(@NonNull DraftId draftId) {
    super(draftId, Section.ROOT);
  }
}

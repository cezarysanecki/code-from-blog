package io.csanecki.cqrs.utils;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.section.Section;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {

  @NonNull
  private final DraftId draftId;

  @NonNull
  private final Section section;

  public DraftId getDraftId() {
    return draftId;
  }

  public Section getSection() {
    return section;
  }
}

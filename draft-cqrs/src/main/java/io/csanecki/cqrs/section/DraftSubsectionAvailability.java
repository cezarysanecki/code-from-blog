package io.csanecki.cqrs.section;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class DraftSubsectionAvailability {

  private final RootSectionAvailability rootSectionAvailability;

  public SectionAvailability checkAvailability(@NonNull DraftId draftId) {
    SectionAvailability rootAvailability = rootSectionAvailability.checkAvailability(draftId);
    if (rootAvailability.isReadOnly()) {
      return SectionAvailability.READ_ONLY;
    }
    return checkSubsectionAvailability(draftId);
  }

  public boolean isEditable(@NonNull DraftId draftId) {
    return checkAvailability(draftId)
        .isEditable();
  }

  protected abstract SectionAvailability checkSubsectionAvailability(@NonNull DraftId draftId);

}

package io.csanecki.draft.draft;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.section.RootSectionAvailability;
import io.csanecki.draft.section.SectionAvailability;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class DraftSectionAvailability implements RootSectionAvailability {

  private final DraftRepository draftRepository;

  @Override
  public boolean isEditable(@NonNull DraftId draftId) {
    return checkAvailability(draftId)
        .isEditable();
  }

  @Override
  public SectionAvailability checkAvailability(@NonNull DraftId draftId) {
    Draft draft = draftRepository.findByDraftIdForce(draftId);
    return draft.isApproved() ? SectionAvailability.READ_ONLY : SectionAvailability.EDITABLE;
  }
}

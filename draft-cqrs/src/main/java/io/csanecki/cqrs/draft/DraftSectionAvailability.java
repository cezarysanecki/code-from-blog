package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.section.RootSectionAvailability;
import io.csanecki.cqrs.section.SectionAvailability;
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

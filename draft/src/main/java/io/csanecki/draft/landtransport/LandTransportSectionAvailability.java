package io.csanecki.draft.landtransport;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.section.DraftSubsectionAvailability;
import io.csanecki.draft.section.RootSectionAvailability;
import io.csanecki.draft.section.SectionAvailability;
import lombok.NonNull;

class LandTransportSectionAvailability extends DraftSubsectionAvailability {

  public LandTransportSectionAvailability(@NonNull RootSectionAvailability rootSectionAvailability) {
    super(rootSectionAvailability);
  }

  @Override
  protected SectionAvailability checkSubsectionAvailability(@NonNull DraftId draftId) {
    return SectionAvailability.EDITABLE;
  }
}

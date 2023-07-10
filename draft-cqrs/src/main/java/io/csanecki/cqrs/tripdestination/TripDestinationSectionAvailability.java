package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.section.DraftSubsectionAvailability;
import io.csanecki.cqrs.section.RootSectionAvailability;
import io.csanecki.cqrs.section.SectionAvailability;
import lombok.NonNull;

class TripDestinationSectionAvailability extends DraftSubsectionAvailability {

  public TripDestinationSectionAvailability(@NonNull RootSectionAvailability rootSectionAvailability) {
    super(rootSectionAvailability);
  }

  @Override
  protected SectionAvailability checkSubsectionAvailability(@NonNull DraftId draftId) {
    return SectionAvailability.EDITABLE;
  }
}

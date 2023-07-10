package io.csanecki.cqrs.landtransport.api;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.section.Section;
import io.csanecki.cqrs.utils.NotFoundException;
import lombok.NonNull;

public class LandTransportNotFoundException extends NotFoundException {

  public LandTransportNotFoundException(@NonNull DraftId draftId) {
    super(draftId, Section.LAND_TRANSPORT);
  }
}

package io.csanecki.draft.landtransport.api;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.section.Section;
import io.csanecki.draft.utils.NotFoundException;
import lombok.NonNull;

public class LandTransportNotFoundException extends NotFoundException {

  public LandTransportNotFoundException(@NonNull DraftId draftId) {
    super(draftId, Section.LAND_TRANSPORT);
  }
}

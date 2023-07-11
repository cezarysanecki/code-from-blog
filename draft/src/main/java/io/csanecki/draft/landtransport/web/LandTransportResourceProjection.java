package io.csanecki.draft.landtransport.web;

import io.csanecki.draft.draft.api.DraftId;
import lombok.NonNull;

public interface LandTransportResourceProjection {

  LandTransportResource findProjectionByDraftId(@NonNull DraftId draftId);

}

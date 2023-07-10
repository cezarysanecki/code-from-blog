package io.csanecki.cqrs.landtransport.web;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

public interface LandTransportResourceProjection {

  LandTransportResource findProjectionByDraftId(@NonNull DraftId draftId);

}

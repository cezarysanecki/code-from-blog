package io.csanecki.draft.landtransport.port;

import io.csanecki.draft.draft.api.DraftId;
import lombok.NonNull;

public interface TripDestinationForLandTransportQueryPort {

  boolean containsDestination(@NonNull DraftId draftId);

}

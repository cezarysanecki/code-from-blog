package io.csanecki.cqrs.landtransport.port;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

public interface TripDestinationForLandTransportQueryPort {

  boolean containsDestination(@NonNull DraftId draftId);

}

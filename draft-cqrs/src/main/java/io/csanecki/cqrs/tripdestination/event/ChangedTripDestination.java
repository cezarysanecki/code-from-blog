package io.csanecki.cqrs.tripdestination.event;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.tripdestination.api.Country;
import lombok.NonNull;

public record ChangedTripDestination(@NonNull DraftId draftId, @NonNull Country destination) {
}

package io.csanecki.cqrs.tripdestination.event;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.tripdestination.api.Country;
import jakarta.annotation.Nullable;
import lombok.NonNull;

public record ChangedTripDestination(@NonNull DraftId draftId, @Nullable Country destination) {
}

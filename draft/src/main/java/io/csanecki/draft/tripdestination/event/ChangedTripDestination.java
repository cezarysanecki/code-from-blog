package io.csanecki.draft.tripdestination.event;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.tripdestination.api.Country;
import jakarta.annotation.Nullable;
import lombok.NonNull;

public record ChangedTripDestination(@NonNull DraftId draftId, @Nullable Country destination) {
}

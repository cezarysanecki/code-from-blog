package io.csanecki.cqrs.draft.event;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

public record DraftCreated(@NonNull DraftId draftId) {
}

package io.csanecki.draft.draft.event;

import io.csanecki.draft.draft.api.DraftId;
import lombok.NonNull;

public record DraftCreated(@NonNull DraftId draftId) {
}

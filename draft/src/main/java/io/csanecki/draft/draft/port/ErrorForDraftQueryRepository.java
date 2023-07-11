package io.csanecki.draft.draft.port;

import io.csanecki.draft.draft.api.DraftId;
import lombok.NonNull;

public interface ErrorForDraftQueryRepository {

  boolean containsErrors(@NonNull DraftId draftId);

}

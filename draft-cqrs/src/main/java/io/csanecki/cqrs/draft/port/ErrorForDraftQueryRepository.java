package io.csanecki.cqrs.draft.port;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

public interface ErrorForDraftQueryRepository {

  boolean containsErrors(@NonNull DraftId draftId);

}

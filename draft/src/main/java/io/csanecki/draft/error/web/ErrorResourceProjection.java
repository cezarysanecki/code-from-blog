package io.csanecki.draft.error.web;

import io.csanecki.draft.draft.api.DraftId;
import lombok.NonNull;

import java.util.Set;

public interface ErrorResourceProjection {

  Set<ErrorResource> findProjectionAllByDraftId(@NonNull DraftId draftId);

}

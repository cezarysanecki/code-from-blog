package io.csanecki.cqrs.errors.web;

import io.csanecki.cqrs.draft.api.DraftId;
import lombok.NonNull;

import java.util.Set;

public interface ErrorResourceProjection {

  Set<ErrorResource> findProjectionAllByDraftId(@NonNull DraftId draftId);

}

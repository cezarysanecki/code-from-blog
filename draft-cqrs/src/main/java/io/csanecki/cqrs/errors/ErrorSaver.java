package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.DraftId;

import java.util.Collection;

public interface ErrorSaver {

  void clearAndSave(DraftId draftId, Collection<Error> errors);
}

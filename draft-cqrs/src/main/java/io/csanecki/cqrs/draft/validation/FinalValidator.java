package io.csanecki.cqrs.draft.validation;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.error.api.Error;
import lombok.NonNull;

import java.util.Collection;

public interface FinalValidator {

  Collection<Error> validate(@NonNull DraftId draftId);

}

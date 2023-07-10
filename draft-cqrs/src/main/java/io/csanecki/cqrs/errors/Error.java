package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.draft.FieldLocation;
import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;

import java.util.Optional;

public interface Error {

  DraftId draftId();

  Optional<FieldName> fieldName();

  Section section();

  ErrorCode errorCode();

}

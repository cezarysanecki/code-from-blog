package io.csanecki.cqrs.errors.api;

import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;

public interface Error {

  FieldName fieldName();

  Section section();

  ErrorCode errorCode();

}

package io.csanecki.cqrs.errors.api;

import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;
import io.csanecki.cqrs.errors.api.ErrorCode;

public interface Error {

  FieldName fieldName();

  Section section();

  ErrorCode errorCode();

}

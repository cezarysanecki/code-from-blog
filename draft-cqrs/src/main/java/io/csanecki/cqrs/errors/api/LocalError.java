package io.csanecki.cqrs.errors.api;

import io.csanecki.cqrs.draft.ErrorScope;
import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class LocalError implements Error {

  @NonNull
  Section section;

  @NonNull
  ErrorCode errorCode;

  @NonNull
  FieldName fieldName;

  @Override
  public Section section() {
    return section;
  }

  @Override
  public ErrorCode errorCode() {
    return errorCode;
  }

  @Override
  public ErrorScope errorScope() {
    return ErrorScope.LOCAL;
  }
}

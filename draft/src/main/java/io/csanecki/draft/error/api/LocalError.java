package io.csanecki.draft.error.api;

import io.csanecki.draft.utils.ErrorScope;
import io.csanecki.draft.utils.FieldName;
import io.csanecki.draft.section.Section;
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

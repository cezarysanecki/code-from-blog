package io.csanecki.cqrs.errors.api;

import io.csanecki.cqrs.utils.ErrorScope;
import io.csanecki.cqrs.utils.Section;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class GlobalError implements Error {

  @NonNull
  Section section;

  @NonNull
  ErrorCode errorCode;

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
    return ErrorScope.GLOBAL;
  }
}

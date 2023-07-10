package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;
import io.csanecki.cqrs.errors.api.Error;
import io.csanecki.cqrs.errors.api.ErrorCode;
import lombok.Value;

@Value(staticConstructor = "of")
class TripDestinationError implements Error {

  FieldName fieldName;
  ErrorCode errorCode;

  public static TripDestinationError REQUIRED_DESTINATION = TripDestinationError.of(
      FieldName.of(TripDestinationFields.DESTINATION), ErrorCode.REQUIRED_FIELD);

  @Override
  public FieldName fieldName() {
    return fieldName;
  }

  @Override
  public Section section() {
    return Section.LAND_TRANSPORT;
  }

  @Override
  public ErrorCode errorCode() {
    return errorCode;
  }
}

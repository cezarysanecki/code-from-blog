package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;
import io.csanecki.cqrs.errors.Error;
import io.csanecki.cqrs.errors.ErrorCode;
import lombok.Value;

@Value(staticConstructor = "of")
class LandTransportError implements Error {

  FieldName fieldName;
  ErrorCode errorCode;

  public static LandTransportError REQUIRED_FORM_OF_TRANSPORT = LandTransportError.of(
      FieldName.of(LandTransportFields.FORM_OF_TRANSPORT), ErrorCode.REQUIRED_FIELD);

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

package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;
import io.csanecki.cqrs.errors.Error;
import io.csanecki.cqrs.errors.ErrorCode;
import jakarta.annotation.Nullable;
import lombok.Value;

import java.util.Optional;
import java.util.function.Function;

@Value(staticConstructor = "of")
class LandTransportError implements Error {

  DraftId draftId;
  @Nullable
  FieldName fieldName;
  ErrorCode errorCode;

  public static Function<DraftId, LandTransportError> REQUIRED_FORM_OF_TRANSPORT = (DraftId draftId) ->
      LandTransportError.of(draftId, FieldName.of(LandTransportFields.FORM_OF_TRANSPORT), ErrorCode.REQUIRED_FIELD);

  @Override
  public DraftId draftId() {
    return draftId;
  }

  @Override
  public Optional<FieldName> fieldName() {
    return Optional.ofNullable(fieldName);
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

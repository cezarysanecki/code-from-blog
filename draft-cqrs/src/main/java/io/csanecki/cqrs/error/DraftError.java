package io.csanecki.cqrs.error;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.utils.ErrorScope;
import io.csanecki.cqrs.utils.FieldName;
import io.csanecki.cqrs.error.api.Error;
import io.csanecki.cqrs.error.api.ErrorCode;
import io.csanecki.cqrs.error.api.GlobalError;
import io.csanecki.cqrs.error.api.LocalError;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class DraftError {

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  private DraftId draftId;

  @Embedded
  @Nullable
  private FieldName fieldName;

  @NonNull
  @Enumerated(EnumType.STRING)
  private ErrorScope errorScope;

  @Embedded
  private ErrorCode errorCode;

  private DraftError(
      @NonNull DraftId draftId,
      @Nullable FieldName fieldName,
      @NonNull ErrorScope errorScope,
      @NonNull ErrorCode errorCode
  ) {
    this.draftId = draftId;
    this.fieldName = fieldName;
    this.errorScope = errorScope;
    this.errorCode = errorCode;
  }

  static DraftError from(
      @NonNull DraftId draftId,
      @NonNull Error error
  ) {
    if (error instanceof LocalError localError) {
      return new DraftError(draftId, localError.getFieldName(), localError.errorScope(), localError.errorCode());
    } else if (error instanceof GlobalError globalError) {
      return new DraftError(draftId, null, globalError.errorScope(), globalError.errorCode());
    }
    throw new IllegalArgumentException("cannot resolve error type");
  }

  ErrorId getErrorId() {
    return ErrorId.of(id);
  }

}
package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.errors.api.Error;
import io.csanecki.cqrs.errors.api.ErrorCode;
import jakarta.annotation.Nullable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
  private FieldLocation fieldLocation;

  @Embedded
  private ErrorCode errorCode;

  private DraftError(DraftId draftId, FieldLocation fieldLocation, ErrorCode errorCode) {
    this.draftId = draftId;
    this.fieldLocation = fieldLocation;
    this.errorCode = errorCode;
  }

  static DraftError from(DraftId draftId, Error error) {
    return new DraftError(draftId, FieldLocation.of(error.section(), error.fieldName()), error.errorCode());
  }

  ErrorId getErrorId() {
    return ErrorId.of(id);
  }

}

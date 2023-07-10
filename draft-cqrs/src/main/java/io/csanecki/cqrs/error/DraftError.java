package io.csanecki.cqrs.error;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.error.api.Error;
import io.csanecki.cqrs.error.api.ErrorCode;
import io.csanecki.cqrs.error.api.GlobalError;
import io.csanecki.cqrs.error.api.LocalError;
import io.csanecki.cqrs.section.Section;
import io.csanecki.cqrs.utils.ErrorScope;
import io.csanecki.cqrs.utils.FieldName;
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
  @AttributeOverride(name = "value", column = @Column(name = "draft_id"))
  private DraftId draftId;

  @NonNull
  @Enumerated(EnumType.STRING)
  Section section;

  @Nullable
  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "field_name"))
  private FieldName fieldName;

  @NonNull
  @Enumerated(EnumType.STRING)
  private ErrorScope errorScope;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "error_code"))
  private ErrorCode errorCode;

  private DraftError(
      @NonNull DraftId draftId,
      @NonNull Section section,
      @Nullable FieldName fieldName,
      @NonNull ErrorScope errorScope,
      @NonNull ErrorCode errorCode
  ) {
    this.draftId = draftId;
    this.section = section;
    this.fieldName = fieldName;
    this.errorScope = errorScope;
    this.errorCode = errorCode;
  }

  static DraftError from(
      @NonNull DraftId draftId,
      @NonNull Error error
  ) {
    if (error instanceof LocalError localError) {
      return new DraftError(
          draftId,
          localError.section(),
          localError.getFieldName(),
          localError.errorScope(),
          localError.errorCode());
    } else if (error instanceof GlobalError globalError) {
      return new DraftError(
          draftId,
          globalError.section(),
          null,
          globalError.errorScope(),
          globalError.errorCode());
    }
    throw new IllegalArgumentException("cannot resolve error type");
  }

  ErrorId getErrorId() {
    return ErrorId.of(id);
  }

}

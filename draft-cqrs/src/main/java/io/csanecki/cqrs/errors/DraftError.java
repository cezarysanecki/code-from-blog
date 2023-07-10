package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.draft.FieldLocation;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DraftError {

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  private DraftId draftId;

  @Embedded
  private FieldLocation fieldLocation;

  @Embedded
  private ErrorCode errorCode;

  private DraftError(DraftId draftId, FieldLocation fieldLocation, ErrorCode errorCode) {
    this.draftId = draftId;
    this.fieldLocation = fieldLocation;
    this.errorCode = errorCode;
  }

  public static DraftError of(DraftId draftId, FieldLocation fieldLocation, ErrorCode errorCode) {
    return new DraftError(draftId, fieldLocation, errorCode);
  }

  public ErrorId getErrorId() {
    return ErrorId.of(id);
  }

}

package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.api.DraftValidationException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Draft {

  @Id
  @GeneratedValue
  private Long id;

  boolean approved;

  static Draft create() {
    return new Draft();
  }

  public DraftId getDraftId() {
    return DraftId.of(id);
  }

  void approve() {
    if (approved) {
      throw new DraftValidationException(getDraftId(), DraftError.GLOBAL_DRAFT_CANNOT_BE_ACCEPTED);
    }
    this.approved = true;
  }
}

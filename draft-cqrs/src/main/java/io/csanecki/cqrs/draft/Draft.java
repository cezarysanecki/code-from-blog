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

  private boolean approved;

  static Draft create() {
    return new Draft();
  }

  void approve() {
    if (approved) {
      throw new DraftValidationException(getDraftId(), DraftError.GLOBAL_DRAFT_CANNOT_BE_ACCEPTED);
    }
    this.approved = true;
  }

  boolean isApproved() {
    return approved;
  }

  DraftId getDraftId() {
    return DraftId.of(id);
  }
}

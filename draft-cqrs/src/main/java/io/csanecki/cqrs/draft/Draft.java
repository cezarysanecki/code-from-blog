package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
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

  static Draft create() {
    return new Draft();
  }

  public DraftId getDraftId() {
    return DraftId.of(id);
  }

}

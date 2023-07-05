package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.DraftId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Error {

  @Id
  @GeneratedValue
  private Long id;

  private DraftId draftId;

  public ErrorId getErrorId() {
    return ErrorId.of(id);
  }

}

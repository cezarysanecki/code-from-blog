package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.DraftId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TripDestination {

  @Id
  @GeneratedValue
  Long id;

  @Embedded
  DraftId draftId;

  @Enumerated(EnumType.STRING)
  Country desination;

  private TripDestination(DraftId draftId) {
    this.draftId = draftId;
  }

  public static TripDestination newOneFor(@NonNull DraftId draftId) {
    return new TripDestination(draftId);
  }

}

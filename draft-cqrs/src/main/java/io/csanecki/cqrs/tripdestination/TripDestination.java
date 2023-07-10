package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.tripdestination.api.Country;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class TripDestination {

  @Id
  @GeneratedValue
  Long id;

  @Embedded
  DraftId draftId;

  @Enumerated(EnumType.STRING)
  Country destination;

  private TripDestination(DraftId draftId) {
    this.draftId = draftId;
  }

  static TripDestination newOneFor(@NonNull DraftId draftId) {
    return new TripDestination(draftId);
  }

}

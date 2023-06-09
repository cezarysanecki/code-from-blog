package io.csanecki.draft.tripdestination;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.tripdestination.api.Country;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class TripDestination {

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "draft_id"))
  private DraftId draftId;

  @Enumerated(EnumType.STRING)
  private Country destination;

  private TripDestination(
      @NonNull DraftId draftId
  ) {
    this.draftId = draftId;
  }

  static TripDestination newOne(
      @NonNull DraftId draftId
  ) {
    return new TripDestination(draftId);
  }

  void setDestination(Country destination) {
    this.destination = destination;
  }

  DraftId getDraftId() {
    return draftId;
  }

  public Optional<Country> getDestination() {
    return Optional.ofNullable(destination);
  }
}

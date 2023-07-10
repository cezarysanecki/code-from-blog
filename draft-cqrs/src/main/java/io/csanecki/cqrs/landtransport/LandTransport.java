package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.DraftId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class LandTransport {

  @Id
  @GeneratedValue
  Long id;

  @Embedded
  DraftId draftId;

  @Enumerated(EnumType.STRING)
  FormOfTransport formOfTransport;

  private LandTransport(DraftId draftId) {
    this.draftId = draftId;
  }

  static LandTransport newOne(@NonNull DraftId draftId) {
    return new LandTransport(draftId);
  }

}

package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class LandTransport {

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  private DraftId draftId;

  @Enumerated(EnumType.STRING)
  private FormOfTransport formOfTransport;

  private LandTransport(
      @NonNull DraftId draftId
  ) {
    this.draftId = draftId;
  }

  static LandTransport newOne(
      @NonNull DraftId draftId
  ) {
    return new LandTransport(draftId);
  }

}

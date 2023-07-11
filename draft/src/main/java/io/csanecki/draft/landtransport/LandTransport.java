package io.csanecki.draft.landtransport;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.landtransport.api.FormOfTransport;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class LandTransport {

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "draft_id"))
  private DraftId draftId;

  @Nullable
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

  void setFormOfTransport(FormOfTransport formOfTransport) {
    this.formOfTransport = formOfTransport;
  }

  DraftId getDraftId() {
    return draftId;
  }

  Optional<FormOfTransport> getFormOfTransport() {
    return Optional.ofNullable(formOfTransport);
  }
}

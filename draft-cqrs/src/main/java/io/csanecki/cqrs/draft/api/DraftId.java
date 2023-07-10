package io.csanecki.cqrs.draft.api;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Access(AccessType.FIELD)
@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DraftId {

  @NonNull
  private Long value;

  public static DraftId of(
      @NonNull Long value
  ) {
    return new DraftId(value);
  }

  public Long toLong() {
    return value;
  }

  public Long getValue() {
    return value;
  }
}

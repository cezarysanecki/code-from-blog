package io.csanecki.cqrs.draft;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DraftId {

  @NonNull
  Long value;

  public static DraftId of(Long value) {
    return new DraftId(value);
  }

  public Long toLong() {
    return value;
  }
}

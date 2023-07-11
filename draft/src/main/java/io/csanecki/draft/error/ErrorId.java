package io.csanecki.draft.error;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class ErrorId {

  @NonNull
  private Long value;

  static ErrorId of(
      @NonNull Long value
  ) {
    return new ErrorId(value);
  }

  Long toLong() {
    return value;
  }
}

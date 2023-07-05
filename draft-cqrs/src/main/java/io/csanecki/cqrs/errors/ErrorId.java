package io.csanecki.cqrs.errors;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorId {

  @NonNull
  Long value;

  public static ErrorId of(Long value) {
    return new ErrorId(value);
  }

  public Long toLong() {
    return value;
  }
}

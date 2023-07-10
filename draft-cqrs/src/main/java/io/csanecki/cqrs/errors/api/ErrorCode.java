package io.csanecki.cqrs.errors.api;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorCode {

  String code;

  public static ErrorCode of(@NonNull String field) {
    return new ErrorCode(field);
  }

  public static final ErrorCode REQUIRED_FIELD = ErrorCode.of("REQUIRED_FIELD");
}

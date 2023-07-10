package io.csanecki.cqrs.error.api;

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
public class ErrorCode {

  @NonNull
  private String value;

  public static ErrorCode of(
      @NonNull String field
  ) {
    return new ErrorCode(field);
  }

  public static final ErrorCode REQUIRED_FIELD = ErrorCode.of("REQUIRED_FIELD");
  public static final ErrorCode UNEDITABLE = ErrorCode.of("UNEDITABLE");

  public String getValue() {
    return value;
  }
}

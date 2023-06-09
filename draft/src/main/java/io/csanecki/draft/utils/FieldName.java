package io.csanecki.draft.utils;

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
public class FieldName {

  @NonNull
  private String value;

  public static FieldName empty() {
    return new FieldName("-");
  }

  public static FieldName of(
      @NonNull String field
  ) {
    return new FieldName(field);
  }

  public String getValue() {
    return value;
  }
}

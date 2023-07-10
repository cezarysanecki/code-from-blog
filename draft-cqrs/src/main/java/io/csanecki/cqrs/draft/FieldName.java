package io.csanecki.cqrs.draft;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FieldName {

  String value;

  public static FieldName empty() {
    return new FieldName("-");
  }

  public static FieldName of(@NonNull String field) {
    return new FieldName(field);
  }
}

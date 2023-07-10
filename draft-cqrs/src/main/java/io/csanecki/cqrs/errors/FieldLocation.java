package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.utils.FieldName;
import io.csanecki.cqrs.utils.Section;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class FieldLocation {

  @NonNull
  private Section section;

  @NonNull
  private FieldName fieldName;

}

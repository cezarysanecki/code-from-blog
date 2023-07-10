package io.csanecki.cqrs.errors;

import io.csanecki.cqrs.draft.FieldName;
import io.csanecki.cqrs.draft.Section;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class FieldLocation {

  Section section;

  FieldName fieldName;

}

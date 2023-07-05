package io.csanecki.modules.utils.vo;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WarningId {

  @NonNull
  Long value;

}

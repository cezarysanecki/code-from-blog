package io.csanecki.modules.utils.vo;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CitizenId {

  @NonNull
  Long value;

  public Long toLong() {
    return value;
  }
}

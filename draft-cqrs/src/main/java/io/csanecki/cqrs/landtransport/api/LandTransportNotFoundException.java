package io.csanecki.cqrs.landtransport.api;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.utils.NotFoundException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class LandTransportNotFoundException extends NotFoundException {

  @NonNull
  DraftId draftId;

}

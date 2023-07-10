package io.csanecki.cqrs.draft.api;

import io.csanecki.cqrs.utils.NotFoundException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class DraftNotFoundException extends NotFoundException {

  @NonNull
  DraftId draftId;

}

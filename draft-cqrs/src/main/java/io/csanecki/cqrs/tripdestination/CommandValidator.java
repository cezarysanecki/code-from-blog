package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.tripdestination.command.UpdateDestinationCommand;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CommandValidator {

  void validate(
      @NonNull DraftId draftId,
      @NonNull UpdateDestinationCommand command
  ) {
    // some logic....
  }

}

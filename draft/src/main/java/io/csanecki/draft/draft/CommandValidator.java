package io.csanecki.draft.draft;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.draft.api.DraftProcessException;
import io.csanecki.draft.draft.api.DraftValidationException;
import io.csanecki.draft.draft.command.ApproveDraftCommand;
import io.csanecki.draft.draft.port.ErrorForDraftQueryRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CommandValidator {

  private final DraftSectionAvailability draftSectionAvailability;
  private final ErrorForDraftQueryRepository errorForDraftQueryRepository;

  void validate(
      @NonNull DraftId draftId,
      @NonNull ApproveDraftCommand command
  ) {
    if (!draftSectionAvailability.isEditable(draftId)) {
      throw new DraftValidationException(draftId, DraftError.GLOBAL_DRAFT_IS_NOT_EDITABLE);
    }

    boolean containsErrors = errorForDraftQueryRepository.containsErrors(draftId);

    if (containsErrors) {
      throw new DraftProcessException(draftId);
    }
  }

}

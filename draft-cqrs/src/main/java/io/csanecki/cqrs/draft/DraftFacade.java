package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.command.ApproveDraftCommand;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class DraftFacade {

  private final DraftRepository draftRepository;
  private final CommandValidator commandValidator;

  @Transactional
  public DraftId createDraft() {
    return draftRepository.save(Draft.create())
        .getDraftId();
  }

  @Transactional
  public void approve(@NonNull DraftId draftId, @NonNull ApproveDraftCommand command) {
    commandValidator.validate(draftId, command);

    Draft draft = draftRepository.findByDraftIdForce(draftId);
    draft.approve();
  }

}

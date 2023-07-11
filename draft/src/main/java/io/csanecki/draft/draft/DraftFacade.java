package io.csanecki.draft.draft;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.draft.command.ApproveDraftCommand;
import io.csanecki.draft.draft.event.DraftCreated;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class DraftFacade {

  private final DraftRepository draftRepository;
  private final CommandValidator commandValidator;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Transactional
  public DraftId createDraft() {
    Draft draft = draftRepository.save(Draft.create());

    applicationEventPublisher.publishEvent(new DraftCreated(draft.getDraftId()));

    return draft.getDraftId();
  }

  @Transactional
  public void approve(@NonNull DraftId draftId, @NonNull ApproveDraftCommand command) {
    commandValidator.validate(draftId, command);

    Draft draft = draftRepository.findByDraftIdForce(draftId);
    draft.approve();
  }

}

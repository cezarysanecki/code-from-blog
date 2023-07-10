package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.command.ApproveDraftCommand;
import io.csanecki.cqrs.draft.event.DraftCreated;
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

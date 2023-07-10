package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.api.DraftId;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class DraftFacade {

  private final DraftRepository draftRepository;

  @Transactional
  public DraftId createDraft() {
    return draftRepository.save(Draft.create())
        .getDraftId();
  }

}

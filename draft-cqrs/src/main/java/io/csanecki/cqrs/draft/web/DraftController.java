package io.csanecki.cqrs.draft.web;

import io.csanecki.cqrs.draft.DraftFacade;
import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.command.ApproveDraftCommand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/draft")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class DraftController {

  private final DraftFacade facade;
  private final DraftResourceService draftResourceService;

  @PostMapping("/create")
  ResponseEntity<DraftResource> createDraft() {
    DraftId draftId = facade.createDraft();
    DraftResource draft = draftResourceService.get(draftId);
    return ResponseEntity.ok(draft);
  }

  @PostMapping("/{draftId}/approve")
  ResponseEntity<DraftResource> approveDraft(
      @PathVariable DraftId draftId
  ) {
    facade.approve(draftId, new ApproveDraftCommand());
    DraftResource draft = draftResourceService.get(draftId);
    return ResponseEntity.ok(draft);
  }

}

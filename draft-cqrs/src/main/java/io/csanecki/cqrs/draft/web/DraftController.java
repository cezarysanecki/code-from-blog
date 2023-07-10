package io.csanecki.cqrs.draft.web;

import io.csanecki.cqrs.draft.DraftFacade;
import io.csanecki.cqrs.draft.api.DraftId;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/draft")
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

}

package io.csanecki.draft.landtransport.web;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.draft.web.DraftResource;
import io.csanecki.draft.draft.web.DraftResourceService;
import io.csanecki.draft.landtransport.LandTransportFacade;
import io.csanecki.draft.landtransport.command.UpdateFormOfTransportCommand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/draft/{draftId}/landtransport")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class LandTransportController {

  private final LandTransportFacade facade;
  private final DraftResourceService draftResourceService;

  @PutMapping
  ResponseEntity<DraftResource> updateFormOfTransport(
      @PathVariable DraftId draftId,
      @RequestBody UpdateFormOfTransportCommand command
  ) {
    facade.updateFormOfTransport(draftId, command);
    DraftResource draft = draftResourceService.get(draftId);
    return ResponseEntity.ok(draft);
  }

}

package io.csanecki.cqrs.landtransport.web;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.web.DraftResource;
import io.csanecki.cqrs.draft.web.DraftResourceService;
import io.csanecki.cqrs.landtransport.LandTransportFacade;
import io.csanecki.cqrs.landtransport.command.UpdateFormOfTransportCommand;
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

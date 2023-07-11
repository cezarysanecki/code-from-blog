package io.csanecki.draft.tripdestination.web;

import io.csanecki.draft.draft.api.DraftId;
import io.csanecki.draft.draft.web.DraftResource;
import io.csanecki.draft.draft.web.DraftResourceService;
import io.csanecki.draft.tripdestination.TripDestinationFacade;
import io.csanecki.draft.tripdestination.command.UpdateDestinationCommand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/draft/{draftId}/tripdestination")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationController {

  private final TripDestinationFacade facade;
  private final DraftResourceService draftResourceService;

  @PutMapping
  ResponseEntity<DraftResource> updateDestination(
      @PathVariable DraftId draftId,
      @RequestBody UpdateDestinationCommand command
  ) {
    facade.updateDestination(draftId, command);
    DraftResource draft = draftResourceService.get(draftId);
    return ResponseEntity.ok(draft);
  }

}

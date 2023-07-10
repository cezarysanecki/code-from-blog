package io.csanecki.cqrs.tripdestination.web;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.draft.web.DraftResource;
import io.csanecki.cqrs.draft.web.DraftResourceService;
import io.csanecki.cqrs.tripdestination.TripDestinationFacade;
import io.csanecki.cqrs.tripdestination.command.UpdateDestinationCommand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/draft/{draftId}/landtransport")
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

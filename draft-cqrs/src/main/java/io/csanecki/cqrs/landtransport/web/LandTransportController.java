package io.csanecki.cqrs.landtransport.web;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.landtransport.LandTransportFacade;
import io.csanecki.cqrs.landtransport.command.UpdateFormOfTransportCommand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/draft/{draftId}/landtransport")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class LandTransportController {

  private final LandTransportFacade landTransportFacade;

  @PutMapping
  RequestEntity<Void> updateFormOfTransport(
      @PathVariable DraftId draftId,
      @RequestBody UpdateFormOfTransportCommand command
  ) {
    landTransportFacade.updateFormOfTransport(draftId, command);


  }

}

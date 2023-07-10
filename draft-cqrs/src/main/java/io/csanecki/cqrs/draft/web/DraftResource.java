package io.csanecki.cqrs.draft.web;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.landtransport.web.LandTransportResource;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResource;
import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.web.bind.annotation.ResponseBody;

@Builder(access = AccessLevel.PACKAGE)
@ResponseBody
public class DraftResource {

  DraftId draftId;

  TripDestinationResource tripDestination;

  LandTransportResource landTransport;

}

package io.csanecki.cqrs.draft.web;

import io.csanecki.cqrs.landtransport.web.LandTransportResource;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResource;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Value
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DraftResource {

  Long draftId;

  TripDestinationResource tripDestination;

  LandTransportResource landTransport;

}

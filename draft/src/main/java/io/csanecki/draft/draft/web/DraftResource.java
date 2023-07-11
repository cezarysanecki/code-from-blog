package io.csanecki.draft.draft.web;

import io.csanecki.draft.landtransport.web.LandTransportResource;
import io.csanecki.draft.tripdestination.web.TripDestinationResource;
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

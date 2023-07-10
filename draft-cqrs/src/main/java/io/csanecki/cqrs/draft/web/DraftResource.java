package io.csanecki.cqrs.draft.web;

import io.csanecki.cqrs.draft.api.DraftId;
import io.csanecki.cqrs.error.web.ErrorResource;
import io.csanecki.cqrs.landtransport.web.LandTransportResource;
import io.csanecki.cqrs.tripdestination.web.TripDestinationResource;
import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Builder(access = AccessLevel.PACKAGE)
@ResponseBody
public class DraftResource {

  private DraftId draftId;

  private TripDestinationResource tripDestination;

  private LandTransportResource landTransport;

  private Set<ErrorResource> errors;

}

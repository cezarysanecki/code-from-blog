package io.csanecki.cqrs.tripdestination.web;

import io.csanecki.cqrs.tripdestination.api.Country;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Getter
@ResponseBody
public class TripDestinationResource {

  Country destination;

  public TripDestinationResource(Country destination) {
    this.destination = destination;
  }

}

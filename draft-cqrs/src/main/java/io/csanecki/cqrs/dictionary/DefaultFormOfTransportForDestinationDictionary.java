package io.csanecki.cqrs.dictionary;

import io.csanecki.cqrs.landtransport.DefaultFormOfTransportForDestination;
import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import io.csanecki.cqrs.tripdestination.api.Country;
import lombok.NonNull;

import java.util.Map;

public class DefaultFormOfTransportForDestinationDictionary implements DefaultFormOfTransportForDestination {

  private static final Map<Country, FormOfTransport> ASSIGNMENT = Map.of(
      Country.INDIA, FormOfTransport.BICYCLE,
      Country.SPAIN, FormOfTransport.SCOOTER,
      Country.UNITED_STATES, FormOfTransport.VEHICLE);

  @Override
  public FormOfTransport findFor(@NonNull Country destination) {
    return ASSIGNMENT.get(destination);
  }
}

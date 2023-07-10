package io.csanecki.cqrs.dictionary;

import io.csanecki.cqrs.landtransport.DefaultFormOfTransportForDestination;
import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import io.csanecki.cqrs.tripdestination.api.Country;
import jakarta.annotation.Nullable;

import java.util.Map;
import java.util.Optional;

class DefaultFormOfTransportForDestinationDictionary implements DefaultFormOfTransportForDestination {

  private static final Map<Country, FormOfTransport> ASSIGNMENT = Map.of(
      Country.INDIA, FormOfTransport.BICYCLE,
      Country.SPAIN, FormOfTransport.SCOOTER,
      Country.UNITED_STATES, FormOfTransport.VEHICLE);

  @Nullable
  @Override
  public Optional<FormOfTransport> findFor(@Nullable Country destination) {
    if (destination == null) {
      return Optional.empty();
    }
    return Optional.ofNullable(ASSIGNMENT.get(destination));
  }

}

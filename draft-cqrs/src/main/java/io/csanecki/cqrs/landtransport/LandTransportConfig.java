package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.landtransport.port.TripDestinationForLandTransportQueryPort;
import io.csanecki.cqrs.section.RootSectionAvailability;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LandTransportConfig {

  private final LandTransportRepository landTransportRepository;
  private final TripDestinationForLandTransportQueryPort tripDestinationForLandTransportQueryPort;
  private final DefaultFormOfTransportForDestination defaultFormOfTransportForDestination;

  private final LandTransportSectionAvailability landTransportSectionAvailability;

  LandTransportConfig(
      @NonNull LandTransportRepository landTransportRepository,
      @NonNull RootSectionAvailability rootSectionAvailability,
      @NonNull TripDestinationForLandTransportQueryPort tripDestinationForLandTransportQueryPort,
      @NonNull DefaultFormOfTransportForDestination defaultFormOfTransportForDestination
  ) {
    this.landTransportRepository = landTransportRepository;
    this.tripDestinationForLandTransportQueryPort = tripDestinationForLandTransportQueryPort;
    this.defaultFormOfTransportForDestination = defaultFormOfTransportForDestination;
    this.landTransportSectionAvailability = new LandTransportSectionAvailability(
        rootSectionAvailability);
  }

  @Bean
  LandTransportFacade landTransportFacade() {
    CommandValidator commandValidator = new CommandValidator(
        landTransportSectionAvailability,
        tripDestinationForLandTransportQueryPort);
    return new LandTransportFacade(
        landTransportRepository,
        commandValidator);
  }

  @Bean
  LandTransportEventListener landTransportEventListener() {
    return new LandTransportEventListener(
        landTransportRepository,
        landTransportSectionAvailability,
        defaultFormOfTransportForDestination);
  }

}

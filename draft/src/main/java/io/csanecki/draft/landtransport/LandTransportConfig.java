package io.csanecki.draft.landtransport;

import io.csanecki.draft.dictionary.DraftDictionary;
import io.csanecki.draft.error.api.ErrorSaver;
import io.csanecki.draft.landtransport.port.TripDestinationForLandTransportQueryPort;
import io.csanecki.draft.section.RootSectionAvailability;
import jakarta.persistence.EntityManager;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LandTransportConfig {

  private final LandTransportRepository landTransportRepository;
  private final TripDestinationForLandTransportQueryPort tripDestinationForLandTransportQueryPort;
  private final DefaultFormOfTransportForDestination defaultFormOfTransportForDestination;
  private final EntityManager entityManager;
  private final DraftDictionary draftDictionary;

  private final LandTransportSectionAvailability landTransportSectionAvailability;
  private final LandTransportFinalValidator landTransportFinalValidator;

  LandTransportConfig(
      @NonNull LandTransportRepository landTransportRepository,
      @NonNull RootSectionAvailability rootSectionAvailability,
      @NonNull TripDestinationForLandTransportQueryPort tripDestinationForLandTransportQueryPort,
      @NonNull DefaultFormOfTransportForDestination defaultFormOfTransportForDestination,
      @NonNull EntityManager entityManager,
      @NonNull DraftDictionary draftDictionary,
      @NonNull ErrorSaver errorSaver
  ) {
    this.landTransportRepository = landTransportRepository;
    this.tripDestinationForLandTransportQueryPort = tripDestinationForLandTransportQueryPort;
    this.defaultFormOfTransportForDestination = defaultFormOfTransportForDestination;
    this.entityManager = entityManager;
    this.draftDictionary = draftDictionary;
    this.landTransportSectionAvailability = new LandTransportSectionAvailability(
        rootSectionAvailability);
    this.landTransportFinalValidator = new LandTransportFinalValidator(errorSaver);
  }

  @Bean
  LandTransportFacade landTransportFacade() {
    CommandValidator commandValidator = new CommandValidator(
        landTransportSectionAvailability,
        tripDestinationForLandTransportQueryPort,
        draftDictionary);
    return new LandTransportFacade(
        landTransportRepository,
        commandValidator);
  }

  @Bean
  LandTransportEventListener landTransportEventListener() {
    return new LandTransportEventListener(
        landTransportRepository,
        landTransportSectionAvailability,
        landTransportFinalValidator,
        defaultFormOfTransportForDestination);
  }

  @Bean
  LandTransportQueryRepository landTransportQueryRepository() {
    return new LandTransportQueryRepository(entityManager);
  }

}

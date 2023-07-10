package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.error.api.ErrorSaver;
import io.csanecki.cqrs.section.RootSectionAvailability;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TripDestinationConfig {

  private final TripDestinationRepository tripDestinationRepository;
  private final RootSectionAvailability rootSectionAvailability;
  private final ApplicationEventPublisher applicationEventPublisher;

  private final TripDestinationFinalValidator tripDestinationFinalValidator;

  TripDestinationConfig(
      @NonNull TripDestinationRepository tripDestinationRepository,
      @NonNull RootSectionAvailability rootSectionAvailability,
      @NonNull ApplicationEventPublisher applicationEventPublisher,
      @NonNull ErrorSaver errorSaver
  ) {
    this.tripDestinationRepository = tripDestinationRepository;
    this.rootSectionAvailability = rootSectionAvailability;
    this.applicationEventPublisher = applicationEventPublisher;
    this.tripDestinationFinalValidator = new TripDestinationFinalValidator(errorSaver);
  }

  @Bean
  TripDestinationFacade tripDestinationFacade() {
    TripDestinationSectionAvailability tripDestinationSectionAvailability = new TripDestinationSectionAvailability(
        rootSectionAvailability);
    CommandValidator commandValidator = new CommandValidator(
        tripDestinationSectionAvailability);
    return new TripDestinationFacade(
        tripDestinationRepository,
        commandValidator,
        tripDestinationFinalValidator,
        applicationEventPublisher);
  }

  @Bean
  TripDestinationEventListener tripDestinationEventListener() {
    return new TripDestinationEventListener(
        tripDestinationRepository,
        tripDestinationFinalValidator);
  }

  @Bean
  TripDestinationQueryRepository tripDestinationQueryRepository() {
    return new TripDestinationQueryRepository(tripDestinationRepository);
  }

}

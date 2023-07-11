package io.csanecki.draft.tripdestination;

import io.csanecki.draft.dictionary.DraftDictionary;
import io.csanecki.draft.error.api.ErrorSaver;
import io.csanecki.draft.section.RootSectionAvailability;
import jakarta.persistence.EntityManager;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TripDestinationConfig {

  private final TripDestinationRepository tripDestinationRepository;
  private final RootSectionAvailability rootSectionAvailability;
  private final ApplicationEventPublisher applicationEventPublisher;
  private final EntityManager entityManager;
  private final DraftDictionary draftDictionary;

  private final TripDestinationFinalValidator tripDestinationFinalValidator;

  TripDestinationConfig(
      @NonNull TripDestinationRepository tripDestinationRepository,
      @NonNull RootSectionAvailability rootSectionAvailability,
      @NonNull ApplicationEventPublisher applicationEventPublisher,
      @NonNull EntityManager entityManager,
      @NonNull DraftDictionary draftDictionary,
      @NonNull ErrorSaver errorSaver
  ) {
    this.tripDestinationRepository = tripDestinationRepository;
    this.rootSectionAvailability = rootSectionAvailability;
    this.applicationEventPublisher = applicationEventPublisher;
    this.entityManager = entityManager;
    this.draftDictionary = draftDictionary;
    this.tripDestinationFinalValidator = new TripDestinationFinalValidator(errorSaver);
  }

  @Bean
  TripDestinationFacade tripDestinationFacade() {
    TripDestinationSectionAvailability tripDestinationSectionAvailability = new TripDestinationSectionAvailability(
        rootSectionAvailability);
    CommandValidator commandValidator = new CommandValidator(
        tripDestinationSectionAvailability,
        draftDictionary);
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
    return new TripDestinationQueryRepository(
        tripDestinationRepository,
        entityManager);
  }

}

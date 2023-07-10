package io.csanecki.cqrs.tripdestination;

import io.csanecki.cqrs.section.RootSectionAvailability;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TripDestinationConfig {

  private final TripDestinationRepository tripDestinationRepository;
  private final RootSectionAvailability rootSectionAvailability;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Bean
  TripDestinationFacade tripDestinationFacade() {
    TripDestinationSectionAvailability tripDestinationSectionAvailability = new TripDestinationSectionAvailability(
        rootSectionAvailability);
    CommandValidator commandValidator = new CommandValidator(
        tripDestinationSectionAvailability);
    return new TripDestinationFacade(
        tripDestinationRepository,
        commandValidator,
        applicationEventPublisher);
  }

  @Bean
  TripDestinationEventListener tripDestinationEventListener() {
    return new TripDestinationEventListener(tripDestinationRepository);
  }

}

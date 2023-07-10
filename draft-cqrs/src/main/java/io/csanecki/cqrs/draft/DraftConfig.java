package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.validation.FinalValidator;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
class DraftConfig {

  private final DraftRepository draftRepository;
  private final Collection<FinalValidator> finalValidators;
  private final ApplicationEventPublisher applicationEventPublisher;

  private final DraftSectionAvailability draftSectionAvailability;

  DraftConfig(
      @NonNull DraftRepository draftRepository,
      @NonNull Collection<FinalValidator> finalValidators,
      @NonNull ApplicationEventPublisher applicationEventPublisher
  ) {
    this.draftRepository = draftRepository;
    this.finalValidators = finalValidators;
    this.draftSectionAvailability = new DraftSectionAvailability(draftRepository);
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Bean
  DraftSectionAvailability rootSectionAvailability() {
    return draftSectionAvailability;
  }

  @Bean
  DraftFacade draftFacade() {
    CommandValidator commandValidator = new CommandValidator(
        draftSectionAvailability,
        finalValidators);
    return new DraftFacade(
        draftRepository,
        commandValidator,
        applicationEventPublisher);
  }

}

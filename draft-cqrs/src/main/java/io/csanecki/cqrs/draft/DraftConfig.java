package io.csanecki.cqrs.draft;

import io.csanecki.cqrs.draft.port.ErrorForDraftQueryRepository;
import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DraftConfig {

  private final DraftRepository draftRepository;
  private final ErrorForDraftQueryRepository errorForDraftQueryRepository;
  private final ApplicationEventPublisher applicationEventPublisher;

  private final DraftSectionAvailability draftSectionAvailability;

  DraftConfig(
      @NonNull DraftRepository draftRepository,
      @NonNull ErrorForDraftQueryRepository errorForDraftQueryRepository,
      @NonNull ApplicationEventPublisher applicationEventPublisher
  ) {
    this.draftRepository = draftRepository;
    this.errorForDraftQueryRepository = errorForDraftQueryRepository;
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
        errorForDraftQueryRepository);
    return new DraftFacade(
        draftRepository,
        commandValidator,
        applicationEventPublisher);
  }

}

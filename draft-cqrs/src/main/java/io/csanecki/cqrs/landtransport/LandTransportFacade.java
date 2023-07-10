package io.csanecki.cqrs.landtransport;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.landtransport.command.UpdateFormOfTransportCommand;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class LandTransportFacade {

  private final LandTransportRepository landTransportRepository;
  private final CommandValidator commandValidator;

  @Transactional
  public void updateFormOfTransport(
      @NonNull DraftId draftId,
      @NonNull UpdateFormOfTransportCommand command
  ) {
    commandValidator.validate(draftId, command);

    LandTransport landTransport = landTransportRepository.findByDraftIdForce(draftId);
    landTransport.setFormOfTransport(command.formOfTransport());
  }

}

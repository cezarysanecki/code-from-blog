package io.csanecki.modules.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class ApplicationEventListener {

  private final ApplicationsRepository applicationsRepository;

  @EventListener
  public void handle(WarningAssignedEvent event) {
    Applications applications = applicationsRepository.findAllByCitizenIdForce(event.citizenId());
    applications.increaseNumberOfWarnings();
  }

}

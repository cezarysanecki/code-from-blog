package io.csanecki.modules.event;

import io.csanecki.modules.utils.vo.CitizenId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PendingApplicationsFactory {

  private final ApplicationsRepository applicationsRepository;

  public PendingApplications create(CitizenId citizenId) {
    Applications applications = applicationsRepository.findAllByCitizenIdForce(citizenId);
    return new PendingApplications(applications);
  }

}

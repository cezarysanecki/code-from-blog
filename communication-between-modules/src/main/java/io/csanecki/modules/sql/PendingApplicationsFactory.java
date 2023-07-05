package io.csanecki.modules.sql;

import io.csanecki.modules.utils.vo.CitizenId;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class PendingApplicationsFactory {

  private final ApplicationRepository applicationRepository;
  private final WarningForApplicationRepository warningForApplicationRepository;

  public PendingApplications create(CitizenId citizenId) {
    Set<PendingApplication> pendingApplications = applicationRepository.findPendingApplicationsBy(citizenId);
    int numberOfWarnings = warningForApplicationRepository.countWarningsFor(citizenId);

    return new PendingApplications(citizenId, pendingApplications, numberOfWarnings);
  }

}

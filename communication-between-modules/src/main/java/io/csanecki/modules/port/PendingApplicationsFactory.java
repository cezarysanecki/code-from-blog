package io.csanecki.modules.port;

import io.csanecki.modules.utils.vo.CitizenId;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class PendingApplicationsFactory {

  private final ApplicationRepository applicationRepository;
  private final WarningForApplicationQueryPort warningForApplicationQueryPort;

  public PendingApplications create(CitizenId citizenId) {
    Set<PendingApplication> pendingApplications = applicationRepository.findPendingApplicationsBy(citizenId);
    int numberOfWarnings = warningForApplicationQueryPort.countWarningsFor(citizenId);

    return new PendingApplications(citizenId, pendingApplications, numberOfWarnings);
  }

}

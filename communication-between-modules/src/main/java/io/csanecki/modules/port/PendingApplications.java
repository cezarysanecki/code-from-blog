package io.csanecki.modules.port;

import io.csanecki.modules.utils.exceptions.AwkwardCitizenException;
import io.csanecki.modules.utils.exceptions.ReachMaxPendingApplicationsException;
import io.csanecki.modules.utils.vo.CitizenId;

import java.util.HashSet;
import java.util.Set;

public class PendingApplications {

  private final int MAX_PENDING_APPLICATIONS = 5;
  private final int LIMIT_OF_WARNINGS = 3;

  private final CitizenId citizenId;
  private final Set<PendingApplication> pendingApplications;
  private final int numberOfWarnings;

  public PendingApplications(CitizenId citizenId, Set<PendingApplication> pendingApplications, int numberOfWarnings) {
    this.citizenId = citizenId;
    this.pendingApplications = new HashSet<>(pendingApplications);
    this.numberOfWarnings = numberOfWarnings;
  }

  public void submit(Application application) {
    if (pendingApplications.size() >= MAX_PENDING_APPLICATIONS) {
      throw new ReachMaxPendingApplicationsException(citizenId);
    }
    if (numberOfWarnings >= LIMIT_OF_WARNINGS) {
      throw new AwkwardCitizenException(citizenId);
    }
    application.markAsSubmitted();
    pendingApplications.add(new PendingApplication(application));
  }

}

package io.csanecki.modules.event;

import io.csanecki.modules.utils.exceptions.AwkwardCitizenException;
import io.csanecki.modules.utils.exceptions.ReachMaxPendingApplicationsException;

public class PendingApplications {

  private final int MAX_PENDING_APPLICATIONS = 5;
  private final int LIMIT_OF_WARNINGS = 3;

  private final Applications applications;

  public PendingApplications(Applications applications) {
    this.applications = applications;
  }

  public void submit(Application application) {
    if (applications.numberOfPendingApplications() >= MAX_PENDING_APPLICATIONS) {
      throw new ReachMaxPendingApplicationsException(applications.getCitizenId());
    }
    if (applications.getNumberOfWarnings() >= LIMIT_OF_WARNINGS) {
      throw new AwkwardCitizenException(applications.getCitizenId());
    }
    application.markAsSubmitted();
    applications.add(application);
  }

}

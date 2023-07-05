package io.csanecki.modules.entity.citizen;

import io.csanecki.modules.entity.application.Application;
import io.csanecki.modules.entity.warning.Warning;
import io.csanecki.modules.utils.exceptions.AwkwardCitizenException;
import io.csanecki.modules.utils.exceptions.ReachMaxPendingApplicationsException;
import io.csanecki.modules.utils.vo.CitizenId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Citizen {

  private final int MAX_PENDING_APPLICATIONS = 5;
  private final int LIMIT_OF_WARNINGS = 3;

  @Id
  @GeneratedValue
  private Long id;

  @OneToMany(
      mappedBy = "citizen",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private Set<Application> applications = new HashSet<>();

  @OneToMany(
      mappedBy = "citizen",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private Set<Warning> warnings = new HashSet<>();

  @Version
  int version;

  public static Citizen newOne() {
    return new Citizen();
  }

  public void submit(Application application) {
    if (applications.stream()
        .filter(Application::isPending)
        .count() >= MAX_PENDING_APPLICATIONS) {
      throw new ReachMaxPendingApplicationsException(getCitizenId());
    }
    if (warnings.size() >= LIMIT_OF_WARNINGS) {
      throw new AwkwardCitizenException(getCitizenId());
    }
    application.markAsSubmitted();
    applications.add(application);
  }

  public void assign(Warning warning) {
    warnings.add(warning);
  }

  public CitizenId getCitizenId() {
    return CitizenId.of(id);
  }
}

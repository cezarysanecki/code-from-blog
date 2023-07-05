package io.csanecki.modules.event;

import io.csanecki.modules.utils.vo.CitizenId;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Applications {

  @Id
  Long citizenId;

  int numberOfWarnings;

  @OneToMany(
      mappedBy = "application",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private Set<Application> applications = new HashSet<>();

  @Version
  int version;

  public void add(Application application) {
    applications.add(application);
  }

  public void increaseNumberOfWarnings() {
    numberOfWarnings++;
  }

  public long numberOfPendingApplications() {
    return applications.stream()
        .filter(Application::isPending)
        .count();
  }

  public int getNumberOfWarnings() {
    return numberOfWarnings;
  }

  public CitizenId getCitizenId() {
    return CitizenId.of(citizenId);
  }
}

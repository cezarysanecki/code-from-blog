package io.csanecki.modules.port;

import io.csanecki.modules.utils.vo.ApplicationId;
import io.csanecki.modules.utils.vo.CitizenId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Application {

  @Id
  @GeneratedValue
  private Long id;

  private CitizenId citizenId;

  private LocalDateTime submittedAt;

  private LocalDateTime consideredAt;

  public void markAsSubmitted() {
    this.submittedAt = LocalDateTime.now();
  }

  public boolean isPending() {
    return consideredAt == null;
  }

  public ApplicationId getApplicationId() {
    return ApplicationId.of(id);
  }
}

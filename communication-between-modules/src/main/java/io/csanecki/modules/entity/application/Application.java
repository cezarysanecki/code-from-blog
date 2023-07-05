package io.csanecki.modules.entity.application;

import io.csanecki.modules.entity.citizen.Citizen;
import io.csanecki.modules.event.Applications;
import io.csanecki.modules.utils.vo.ApplicationId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Application {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(optional = false)
  private Applications applications;

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

package io.csanecki.modules.entity.warning;

import io.csanecki.modules.entity.citizen.Citizen;
import io.csanecki.modules.utils.vo.WarningId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Warning {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(optional = false)
  private Citizen citizen;

  public WarningId getWarningId() {
    return WarningId.of(id);
  }

}

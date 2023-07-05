package io.csanecki.modules.entity.citizen;

import io.csanecki.modules.utils.exceptions.CitizenNotFoundException;
import io.csanecki.modules.utils.vo.CitizenId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {

  default Optional<Citizen> findCitizenByCitizenId(CitizenId citizenId) {
    return findById(citizenId.getValue());
  }

  default Citizen findCitizenByCitizenIdForce(CitizenId citizenId) {
    return findCitizenByCitizenId(citizenId)
        .orElseThrow(() -> new CitizenNotFoundException(citizenId));
  }

}

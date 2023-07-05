package io.csanecki.modules.event;

import io.csanecki.modules.utils.exceptions.ApplicationsNotFoundException;
import io.csanecki.modules.utils.vo.CitizenId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ApplicationsRepository extends CrudRepository<Applications, Long> {

  Optional<Applications> findByCitizenId(CitizenId citizenId);

  default Applications findAllByCitizenIdForce(CitizenId citizenId) {
    return findByCitizenId(citizenId)
        .orElseThrow(() -> new ApplicationsNotFoundException(citizenId));
  }

}

package io.csanecki.modules.port;

import io.csanecki.modules.utils.vo.CitizenId;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;
import java.util.stream.Collectors;

public interface ApplicationRepository extends CrudRepository<Application, Long> {

  Set<Application> findAllByCitizenId(CitizenId citizenId);

  default Set<PendingApplication> findPendingApplicationsBy(CitizenId citizenId) {
    return findAllByCitizenId(citizenId)
        .stream()
        .filter(Application::isPending)
        .map(PendingApplication::new)
        .collect(Collectors.toUnmodifiableSet());
  }

}

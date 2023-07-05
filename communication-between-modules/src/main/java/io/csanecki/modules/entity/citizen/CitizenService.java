package io.csanecki.modules.entity.citizen;

import io.csanecki.modules.utils.vo.CitizenId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitizenService {

  private final CitizenRepository citizenRepository;

  public CitizenId registerNewCitizen() {
    Citizen citizen = citizenRepository.save(Citizen.newOne());
    return citizen.getCitizenId();
  }

}

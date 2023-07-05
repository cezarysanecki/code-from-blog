package io.csanecki.modules.port;

import io.csanecki.modules.utils.vo.CitizenId;

public interface WarningForApplicationQueryPort {

  int countWarningsFor(CitizenId citizenId);

}

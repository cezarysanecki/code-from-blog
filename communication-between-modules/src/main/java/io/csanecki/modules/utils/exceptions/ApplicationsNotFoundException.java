package io.csanecki.modules.utils.exceptions;

import io.csanecki.modules.utils.vo.CitizenId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApplicationsNotFoundException extends RuntimeException {

  private final CitizenId citizenId;

}

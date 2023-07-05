package io.csanecki.modules.utils.exceptions;

import io.csanecki.modules.utils.vo.CitizenId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AwkwardCitizenException extends RuntimeException {

  private final CitizenId citizenId;

}

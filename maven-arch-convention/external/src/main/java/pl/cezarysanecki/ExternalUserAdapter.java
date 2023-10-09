package pl.cezarysanecki;

import org.springframework.stereotype.Component;

@Component
class ExternalUserAdapter implements UserPort {
  @Override
  public Result invoke() {
    return new Result();
  }
}

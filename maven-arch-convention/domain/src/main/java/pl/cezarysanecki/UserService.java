package pl.cezarysanecki;

import org.springframework.stereotype.Component;

@Component
class UserService {

  private final UserPort userPort;

  UserService(final UserPort userPort) {
    this.userPort = userPort;
  }

  public void sampleMethod() {
    Result result = userPort.invoke();
    System.out.println(result);
  }

}

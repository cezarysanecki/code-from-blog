package pl.cezarysanecki;

import cezarysanecki.ExternalService;

public class FakeBusinessService implements ExternalService {

  private boolean working = true;

  public void setWorking(boolean working) {
    this.working = working;
  }

  @Override
  public boolean isWorking() {
    return working;
  }
}

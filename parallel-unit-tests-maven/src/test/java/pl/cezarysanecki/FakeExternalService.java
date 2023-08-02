package pl.cezarysanecki;

public class FakeExternalService implements ExternalService {

  private boolean working = true;

  public void setWorking(boolean working) {
    this.working = working;
  }

  @Override
  public boolean isWorking() {
    return working;
  }

}

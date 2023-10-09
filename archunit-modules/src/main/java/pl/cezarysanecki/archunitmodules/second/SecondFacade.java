package pl.cezarysanecki.archunitmodules.second;

import pl.cezarysanecki.archunitmodules.first.api.FirstDto;
import pl.cezarysanecki.archunitmodules.first.internal.FirstInternalService;

public class SecondFacade {

  public void a() {
    FirstDto firstDto = new FirstDto();
  }

  public void b() {
    FirstInternalService firstInternalService = new FirstInternalService();
  }

}

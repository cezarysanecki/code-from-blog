package pl.cezarysanecki.archunitmodules.first;

import pl.cezarysanecki.archunitmodules.first.api.FirstDto;
import pl.cezarysanecki.archunitmodules.first.internal.FirstInternalService;

public class FirstFacade {

  public void a() {
    FirstDto firstDto = new FirstDto();
  }

  public void b() {
    FirstInternalService firstInternalService = new FirstInternalService();
  }

}

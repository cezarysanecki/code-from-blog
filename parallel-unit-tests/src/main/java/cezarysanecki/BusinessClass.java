package cezarysanecki;

public class BusinessClass {

  private final ExternalService externalService;

  public BusinessClass(ExternalService externalService) {
    this.externalService = externalService;
  }

  public String doSomething() {
    if (externalService.isWorking()) {
      return "WORKING!";
    }
    throw new ExternalServiceNotWorkingException();
  }

}

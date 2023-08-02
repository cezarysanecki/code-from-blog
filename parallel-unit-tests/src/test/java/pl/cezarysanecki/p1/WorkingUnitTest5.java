package pl.cezarysanecki.p1;

import cezarysanecki.BusinessClass;
import org.junit.jupiter.api.RepeatedTest;
import pl.cezarysanecki.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkingUnitTest5 extends AbstractTest {

  BusinessClass sut = new BusinessClass(BUSINESS_SERVICE);

  @RepeatedTest(5_000)
  void stringIsReturnedWhenExternalServiceIsWorking() {
    // given
    BUSINESS_SERVICE.setWorking(true);
    // and
    System.out.println(Thread.currentThread() + " - working test - " + BUSINESS_SERVICE);

    // when
    String result = sut.doSomething();

    // then
    assertEquals("WORKING!", result);
  }

}

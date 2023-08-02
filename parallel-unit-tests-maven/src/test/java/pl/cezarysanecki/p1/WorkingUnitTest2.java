package pl.cezarysanecki.p1;

import org.junit.jupiter.api.RepeatedTest;
import pl.cezarysanecki.AbstractTest;
import pl.cezarysanecki.BusinessClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkingUnitTest2 extends AbstractTest {

  BusinessClass sut = new BusinessClass(BUSINESS_SERVICE);

  @RepeatedTest(10_000)
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

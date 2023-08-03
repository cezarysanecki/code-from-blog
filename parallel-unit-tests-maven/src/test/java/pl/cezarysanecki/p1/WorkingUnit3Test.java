package pl.cezarysanecki.p1;

import org.junit.jupiter.api.RepeatedTest;
import pl.cezarysanecki.AbstractTest;
import pl.cezarysanecki.BusinessClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkingUnit3Test extends AbstractTest {

  BusinessClass sut = new BusinessClass(EXTERNAL_SERVICE);

  @RepeatedTest(10_000)
  void stringIsReturnedWhenExternalServiceIsWorking() {
    // given
    EXTERNAL_SERVICE.setWorking(true);
    // and
    // System.out.println(Thread.currentThread() + " - working test - " + EXTERNAL_SERVICE);

    // when
    String result = sut.doSomething();

    // then
    assertEquals("WORKING!", result);
  }

}

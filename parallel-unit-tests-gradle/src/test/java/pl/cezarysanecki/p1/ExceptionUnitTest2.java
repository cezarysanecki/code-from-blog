package pl.cezarysanecki.p1;

import org.junit.jupiter.api.RepeatedTest;
import pl.cezarysanecki.AbstractTest;
import pl.cezarysanecki.BusinessClass;
import pl.cezarysanecki.ExternalServiceNotWorkingException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionUnitTest2 extends AbstractTest {

  BusinessClass sut = new BusinessClass(EXTERNAL_SERVICE);

  @RepeatedTest(10_000)
  void stringIsReturnedWhenExternalServiceIsWorking() {
    // given
    EXTERNAL_SERVICE.setWorking(false);
    // and
    System.out.println(Thread.currentThread() + " - exception test - " + EXTERNAL_SERVICE);

    // when/then
    assertThrows(ExternalServiceNotWorkingException.class, () -> sut.doSomething());
  }

}

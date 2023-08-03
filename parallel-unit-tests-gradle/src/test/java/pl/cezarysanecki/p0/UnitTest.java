package pl.cezarysanecki.p0;

import org.junit.jupiter.api.Test;
import pl.cezarysanecki.AbstractTest;
import pl.cezarysanecki.BusinessClass;
import pl.cezarysanecki.ExternalServiceNotWorkingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTest extends AbstractTest {

  BusinessClass sut = new BusinessClass(EXTERNAL_SERVICE);

  @Test
  void exceptionIfThrownWhenExternalServiceIsNotWorking() {
    // given
    EXTERNAL_SERVICE.setWorking(false);

    // when/then
    assertThrows(ExternalServiceNotWorkingException.class, () -> sut.doSomething());
  }

  @Test
  void stringIsReturnedWhenExternalServiceIsWorking() {
    // given
    EXTERNAL_SERVICE.setWorking(true);

    // when
    String result = sut.doSomething();

    // then
    assertEquals("WORKING!", result);
  }

}

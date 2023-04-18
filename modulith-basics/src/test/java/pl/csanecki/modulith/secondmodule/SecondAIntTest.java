package pl.csanecki.modulith.secondmodule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.modulith.test.ApplicationModuleTest;
import pl.csanecki.modulith.firstmodule.FirstA;

@ApplicationModuleTest
class SecondAIntTest {

  @MockBean
  FirstA firstA;

  @Autowired
  SecondA secondA;

  @Test
  void test() {

  }

}
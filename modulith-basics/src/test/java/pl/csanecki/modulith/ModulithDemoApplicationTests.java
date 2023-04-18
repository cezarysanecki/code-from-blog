package pl.csanecki.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ModulithDemoApplicationTests {

  @Test
  void contextLoads() {
    ApplicationModules.of(ModulithDemoApplication.class).verify();
  }

}

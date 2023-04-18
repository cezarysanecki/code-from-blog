package pl.csanecki.modulith.firstmodule;

import org.springframework.stereotype.Component;
import pl.csanecki.modulith.firstmodule.internal.FirstInternalA;

@Component
public class FirstA {

  private final FirstInternalA firstInternalA;

  FirstA(FirstInternalA firstInternalA) {
    this.firstInternalA = firstInternalA;
  }
}

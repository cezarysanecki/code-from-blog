package pl.devcezz.transactional.propagation;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionHelper {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void withRequiredNew(Runnable task) {
        task.run();
    }
}

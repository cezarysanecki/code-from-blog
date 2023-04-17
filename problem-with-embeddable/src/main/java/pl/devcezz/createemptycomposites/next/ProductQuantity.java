package pl.devcezz.createemptycomposites.next;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class ProductQuantity {

    private Long quantity;

    public void increment() {
        quantity++;
    }

    public Long getQuantity() {
        return quantity;
    }
}

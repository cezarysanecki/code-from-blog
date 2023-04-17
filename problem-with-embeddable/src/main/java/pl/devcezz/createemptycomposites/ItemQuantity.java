package pl.devcezz.createemptycomposites;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class ItemQuantity {

    private Long quantity;

    protected ItemQuantity() {
    }

    private ItemQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public static ItemQuantity empty() {
        return new ItemQuantity(0L);
    }

    public void increment() {
        quantity++;
    }

    public Long getQuantity() {
        return quantity;
    }
}

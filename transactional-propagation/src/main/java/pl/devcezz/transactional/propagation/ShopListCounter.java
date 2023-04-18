package pl.devcezz.transactional.propagation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShopListCounter {

    @GeneratedValue
    @Id
    private Long id;

    private Long shopListId;

    private Integer value = 1;

    public ShopListCounter() {
    }

    ShopListCounter(Long shopListId) {
        this.shopListId = shopListId;
    }

    public void increment() {
        value++;
    }

    Integer getValue() {
        return value;
    }
}

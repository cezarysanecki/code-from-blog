package pl.devcezz.transactional.propagation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShopList {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ShopItem> items = new HashSet<>();

    public ShopList() {
    }

    public void addItem(String name, Integer quantity) {
        items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.increaseQuantity(quantity),
                        () -> items.add(new ShopItem(name, quantity))
                );
    }

    public Set<ShopItem> getItems() {
        return items;
    }

    public Long getId() {
        return id;
    }
}

@Entity
class ShopItem {

    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private Integer quantity;

    public ShopItem() {
    }

    ShopItem(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    void increaseQuantity(Integer value) {
        quantity += value;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
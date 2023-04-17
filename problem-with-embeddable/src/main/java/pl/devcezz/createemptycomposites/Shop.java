package pl.devcezz.createemptycomposites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Shop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Set<Item> items = new HashSet<>();

    protected Shop() {
    }

    private Shop(String name) {
        this.name = name;
    }

    public static Shop of(String name) {
        return new Shop(name);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItemById(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Long getId() {
        return id;
    }
}

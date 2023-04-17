package pl.devcezz.createemptycomposites;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private MetaData metaData;

    @Embedded
    private ItemQuantity quantity;

    protected Item() {
    }

    private Item(String name) {
        this.name = name;
    }

    public static Item of(String name) {
        return new Item(name);
    }

    public void incrementQuantity() {
        quantity.increment();
    }

    public void addLabel(String label) {
        this.metaData.addLabel(label);
    }

    public String printLabels() {
        return metaData.print();
    }

    public Long fetchQuantity() {
        return quantity.getQuantity();
    }

    public void makeEmbeddableFieldsToBeNull() {
        this.metaData = null;
        this.quantity = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package pl.devcezz.createemptycomposites.next;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private MetaData metaData = new MetaData();

    @Embedded
    private ProductQuantity quantity = new ProductQuantity();

    protected Product() {
    }

    private Product(String name) {
        this.name = name;
    }

    public static Product of(String name) {
        return new Product(name);
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
}

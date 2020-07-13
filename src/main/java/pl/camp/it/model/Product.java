package pl.camp.it.model;

import javax.persistence.*;

@Entity(name = "tproduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    private int amount;
    @Column(unique = true)
    private long barcode;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Category category;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public long getBarcode() { return barcode; }

    public void setBarcode(long barcode) { this.barcode = barcode; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", barcode=" + barcode +
                ", category=" + category +
                '}';
    }
}

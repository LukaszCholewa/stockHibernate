package pl.camp.it.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tcategory")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    private boolean exist;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isExist() { return exist; }

    public void setExist(boolean exist) { this.exist = exist; }

    public Set<Product> getProducts() { return products; }

    public void setProducts(Set<Product> products) { this.products = products; }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exist=" + exist +
                ", products=" + products +
                '}';
    }
}

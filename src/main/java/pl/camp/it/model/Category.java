package pl.camp.it.model;

import javax.persistence.*;

@Entity (name = "tcategory")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String categoryname;
    @Column(nullable = false)
    private boolean exist;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return categoryname; }

    public void setName(String name) { this.categoryname = name; }

    public boolean isExist() { return exist; }

    public void setExist(boolean exist) { this.exist = exist; }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + categoryname + '\'' +
                ", exist=" + exist +
                '}';
    }
}

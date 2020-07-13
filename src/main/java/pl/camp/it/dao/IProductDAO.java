package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.model.Product;
import pl.camp.it.session.SessionFactory;

import java.util.Set;

public interface IProductDAO {
    void saveProductToDatabase (Product product);
    Product getProductById(int id);
    Set<Product> getAllProducts();
    Set<Product> getProductsByCategoryName(int id);
}

package pl.camp.it.dao;

import pl.camp.it.model.Product;

import java.util.List;

public interface IProductDAO {
    void saveProductToDatabase (Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategoryName(int id);
    List<Product> getProductsByCategoryFromDataBase(int id);
}

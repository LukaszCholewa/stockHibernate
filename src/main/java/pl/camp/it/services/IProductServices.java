package pl.camp.it.services;

import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

import java.util.List;

public interface IProductServices {
    void showProducts();

    void generateAndSafeProduct(String name, String amount, String barcode, String categoryName);

    void updateProductCategoryToBrakKategorii(List<Product> products, Category brakKategorii);

    void saveProduct(String name, int amount, long barcode, Category category);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(Category category);


}
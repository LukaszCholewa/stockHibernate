package pl.camp.it.services;

import pl.camp.it.model.Category;

public interface IProductServices {
    void showProducts();

    void generateAndSafeProduct(String name, String amount, String barcode, String categoryName);

    void showProductsByCategory();
}

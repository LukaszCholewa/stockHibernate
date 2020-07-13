package pl.camp.it.services;

import pl.camp.it.dao.CategoryDAO;
import pl.camp.it.dao.ICategoryDAO;
import pl.camp.it.dao.IProductDAO;
import pl.camp.it.dao.ProductDAO;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

import java.util.Scanner;

import static pl.camp.it.gui.GUI.showMainMenu;

public class ProductServices implements IProductServices {

    private static Scanner scanner = new Scanner(System.in);
    static IProductDAO productDAO = new ProductDAO();

    @Override
    public void showProducts() {
        System.out.println(productDAO.getAllProducts());
        showMainMenu();
    }

    @Override
    public void generateAndSafeProduct(String name, String amount, String barcode, String categoryName) {
            Product product = new Product();
            product.setName(name);
            product.setAmount(Integer.parseInt(amount));
            product.setBarcode(Long.parseLong(barcode));

            Category category = new Category();
            category.setName(categoryName);
            category.setExist(false);

            product.setCategory(category);

            productDAO.saveProductToDatabase(product);
            showMainMenu();
    }

    @Override
    public void showProductsByCategory() {
        System.out.println("Wpisz kategorię:");
        String category = scanner.nextLine();

        productDAO.getProductsByCategoryName(Integer.parseInt(category));

        showMainMenu();
    }

}

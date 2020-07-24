package pl.camp.it.services;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.camp.it.App;
import pl.camp.it.dao.IProductDAO;
import pl.camp.it.dao.ProductDAO;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;
import pl.camp.it.session.SessionFactory;

import javax.persistence.OneToOne;
import java.util.List;
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
    public void updateProductCategoryToBrakKategorii(List<Product> products, Category brakKategorii) {

        for (Product product : products) {
            product.setCategory(brakKategorii);
            productDAO.saveProductToDatabase(product);
        }
    }

    @Override
    public void saveProduct(String name, int amount, long barcode, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setAmount(amount);
        product.setBarcode(barcode);
        product.setCategory(category);

        productDAO.saveProductToDatabase(product);
    }


    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productDAO.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.camp.it.model.Product WHERE category_id = :id");
        query.setParameter("id", category);
        List<Product> products = query.getResultList();
        session.close();
        return products;
    }
}

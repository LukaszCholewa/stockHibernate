package pl.camp.it.services;

import pl.camp.it.dao.CategoryDAO;
import pl.camp.it.dao.ICategoryDAO;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

import java.util.List;
import java.util.Scanner;

import static pl.camp.it.gui.GUI.showMainMenu;

public class CategoryServices implements ICategoryServices {

    private static Scanner scanner = new Scanner(System.in);
    static ICategoryDAO categoryDAO = new CategoryDAO();


    @Override
    public void showCategories() {
        System.out.println(categoryDAO.getAllCategories());
        showMainMenu();
    }

    @Override
    public void generateAndSafeCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category.setExist(false);

        categoryDAO.saveCategoryToDatabase(category);
        showMainMenu();
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryDAO.getCategoryFromDataBase(name);
    }

    @Override
    public List<Category> GetAllCategories() {

        return (List<Category>) categoryDAO.getAllCategories();
    }

    @Override
    public void deleteCategory(Category category) {
        category.setExist(true);
        categoryDAO.deleteCategoryFromDataBase(category);
    }

    @Override
    public boolean categoryExist(String category) {

        return categoryDAO.checkCategoryInDataBase(category);
    }

    @Override
    public boolean categoryExistWithDeleted(String category) {
        return categoryDAO.checkCategoryInDataBaseWithDeleted(category);
    }
}

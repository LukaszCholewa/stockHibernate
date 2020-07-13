package pl.camp.it.services;

import pl.camp.it.dao.CategoryDAO;
import pl.camp.it.dao.ICategoryDAO;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

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

    /*@Override
    public void deleteCategory() {
        System.out.println("Wpisz kategorię:");
        String category = scanner.nextLine();
        if(category.equals("Brak kategorii")){
            System.out.println("Nie można usunąć kategorii !!");
            deleteCategory();
        }
        categoryDAO.deleteCategoryFromDataBase(category);

            System.out.println("Kategoria została usunięta");
        showMainMenu();
    }*/

}

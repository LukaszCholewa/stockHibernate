package pl.camp.it.services;

import pl.camp.it.model.Category;

import java.util.List;

import static pl.camp.it.gui.GUI.showMainMenu;

public interface ICategoryServices {
    void showCategories();
    void generateAndSafeCategory(String name);
    Category getCategoryByName(String name);
    List<Category> GetAllCategories();
    void deleteCategory(Category category);
    boolean categoryExist(String category);
    boolean categoryExistWithDeleted(String category);

}

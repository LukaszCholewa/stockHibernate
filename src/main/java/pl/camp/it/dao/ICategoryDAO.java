package pl.camp.it.dao;

import pl.camp.it.model.Category;

import java.util.List;

public interface ICategoryDAO {
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    void saveCategoryToDatabase (Category category);
    void deleteCategoryFromDataBase(Category category);
    boolean checkCategoryInDataBase(String category);
    boolean checkCategoryInDataBaseWithDeleted(String category);
    Category getCategoryFromDataBase(String name);
    List<Category> getAllCategoriesFromDataBaseWithDeleted();
}

package pl.camp.it.dao;

import pl.camp.it.model.Category;
import java.util.Set;

public interface ICategoryDAO {
    Category getCategoryById(int id);
    Set<Category> getAllCategories();
    void saveCategoryToDatabase (Category category);
    void deleteCategoryFromDataBase(String category);
}

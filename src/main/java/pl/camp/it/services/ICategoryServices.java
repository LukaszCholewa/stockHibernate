package pl.camp.it.services;

import pl.camp.it.model.Category;

import static pl.camp.it.gui.GUI.showMainMenu;

public interface ICategoryServices {
    void showCategories();
    void generateAndSafeCategory(String name);

}

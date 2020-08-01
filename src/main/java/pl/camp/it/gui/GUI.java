package pl.camp.it.gui;

import pl.camp.it.model.Category;
import pl.camp.it.services.CategoryServices;
import pl.camp.it.services.ICategoryServices;
import pl.camp.it.services.IProductServices;
import pl.camp.it.services.ProductServices;
import pl.camp.it.session.SessionFactory;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static ICategoryServices iCategoryServices = new CategoryServices();
    private static IProductServices iProductServices = new ProductServices();

    public static void showMainMenu() {

        System.out.println("------------------------");
        System.out.println("1. Dostępne produkty");
        System.out.println("2. Dostępne produkty z danej kategorii");
        System.out.println("3. Dostępne kategorie");
        System.out.println("4. Dodaj produkt");
        System.out.println("5. Dodaj kategorię");
        System.out.println("6. Usuń kategorię");
        System.out.println("7. Exit");
        System.out.print("Podaj cyfrę: ");

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                iProductServices.showProducts();
                showMainMenu();
                break;
            case "2":
                showProductsFromCategoryScreen();
                showMainMenu();
                break;
            case "3":
                iCategoryServices.showCategories();
                showMainMenu();
                break;
            case "4":
                IProductServices iProductServices = new ProductServices();
                System.out.println("Wpisz nazwę produktu:");
                String name = scanner.nextLine();
                System.out.println("Wpisz ilość:");
                String amount = scanner.nextLine();
                System.out.println("Wpisz kod kreskowy:");
                String barcode = scanner.nextLine();
                System.out.println("Wpisz kategorię:");
                String categoryname = scanner.nextLine();

                iProductServices.generateAndSafeProduct(name, amount, barcode, categoryname);
                System.out.println("Dodano nowy produkt");
                break;
            case "5":
                showAddCategoryScreen();
                showMainMenu();
                break;
            case "6":
                showDeleteProductScreen();
                showMainMenu();
                break;
            case "7":
                SessionFactory.sessionFactory.close();
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór !!");
                showMainMenu();
                break;
        }
    }

    public static void showProductsFromCategoryScreen() {
        System.out.println("Wpisz nazwę kategorii:");
        String category = scanner.nextLine();
        if (iCategoryServices.categoryExist(category)) {
            Category category2 = iCategoryServices.getCategoryByName(category);
            System.out.println(iProductServices.getProductsByCategory(category2));
        } else {
            System.out.println("Nie ma takiej kategorii");
        }
    }

    public static void showDeleteProductScreen() {
        System.out.println("Wpisz nazwę kategorii:");
        String category = scanner.nextLine();
        if (category.equals("Brak kategorii")) {
            System.out.println("Nie można usunąć tej kategorii");
            return;
        }
        if (iCategoryServices.categoryExist(category)) {
            Category category2 = iCategoryServices.getCategoryByName(category);
            Category brakKategorii = iCategoryServices.getCategoryByName("Brak kategorii");
            iProductServices.updateProductCategoryToBrakKategorii(iProductServices.getProductsByCategory(category2),
                    brakKategorii);
            iCategoryServices.deleteCategory(category2);
            System.out.println("Kategoria usunięta, produkty przerzucone do: Brak kategorii");
        } else {
            System.out.println("Nie ma takiej kategorii");
        }
        GUI.showMainMenu();
    }

    public static void showAddCategoryScreen() {
        System.out.println("Podaj nazwę kategorii:");
        String name = scanner.nextLine();
        if (iCategoryServices.categoryExist(name)) {
            System.out.println("Podana kategoria już istnieje");
        } else if (iCategoryServices.categoryExistWithDeleted(name)) {
            System.out.println("Podana kategoria była już wcześniej dodana i została usunięta. Nie można dodać ponownie");
        } else {
            iCategoryServices.generateAndSafeCategory(name);
            System.out.println("Dodano kategorię");
        }
    }

}

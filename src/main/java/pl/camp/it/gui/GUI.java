package pl.camp.it.gui;

import pl.camp.it.dao.ICategoryDAO;
import pl.camp.it.services.CategoryServices;
import pl.camp.it.services.ICategoryServices;
import pl.camp.it.services.IProductServices;
import pl.camp.it.services.ProductServices;
import pl.camp.it.session.SessionFactory;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);
    static ICategoryServices iCategoryServices = new CategoryServices();
    static IProductServices iProductServices = new ProductServices();

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
                break;
            case "2":
                iProductServices.showProductsByCategory();
                break;
            case "3":
                iCategoryServices.showCategories();
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
                ICategoryServices iCategoryServices = new CategoryServices();
                System.out.println("Wpisz nazwę kategorii:");
                String newCategory = scanner.nextLine();

                iCategoryServices.generateAndSafeCategory(newCategory);
                System.out.println("Dodano nową kategorię");
                break;
            case "6":
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
}

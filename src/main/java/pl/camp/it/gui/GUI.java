package pl.camp.it.gui;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);

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
                showProducts();
                break;
            case "2":
                showProductsByCategory();
                break;
            case "3":
                showCategories();
                break;
            case "4":
                addProduct();
                break;
            case "5":
                addCategory();
                break;
            case "6":
                deleteCategory();
                break;
            case "7":
                SQLDb.closeConnection();
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór !!");
                showMainMenu();
                break;
        }
    }
}

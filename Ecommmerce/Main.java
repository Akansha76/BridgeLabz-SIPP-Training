package Ecommmerce;

import Ecommmerce.model.Products;
import Ecommmerce.service.ProductService;
import Ecommmerce.Utils.ProductUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. Display\n3. Update\n4. Delete\n5. Search by Name\n6. Search by Category");
            System.out.println("7. Sort by Name\n8. Sort by Price\n9. Find Product Pairs (Budget)\n10. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID, Name, Category, Price: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String category = sc.next();
                    double price = sc.nextDouble();
                    service.addProduct(new Products(id, name, category, price));
                }
                case 2 -> service.displayProducts();
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new Name, Category, Price: ");
                    String name = sc.next();
                    String category = sc.next();
                    double price = sc.nextDouble();
                    service.updateProduct(id, new Products(id, name, category, price));
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    service.deleteProduct(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter name to search: ");
                    String name = sc.next();
                    List<Products> byName = service.searchByName(name);
                    byName.forEach(Products::display);
                }
                case 6 -> {
                    System.out.print("Enter category to search: ");
                    String category = sc.next();
                    List<Products> byCategory = service.searchByCategory(category);
                    byCategory.forEach(Products::display);
                }
                case 7 -> service.sortByName().forEach(Products::display);
                case 8 -> service.sortByPrice().forEach(Products::display);
                case 9 -> {
                    System.out.print("Enter budget: ");
                    double budget = sc.nextDouble();
                    ProductUtils.findPairsWithinBudget(service.getAllProducts(), budget);
                }
                case 10 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}


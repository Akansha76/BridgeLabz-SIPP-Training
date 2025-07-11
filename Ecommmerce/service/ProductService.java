package Ecommmerce.service;

import Ecommmerce.model.Products;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService implements Searchable {
    private Map<Integer, Products> productMap = new HashMap<>();

    // CRUD Operations
    public void addProduct(Products p) {
        productMap.put(p.getId(), p);
    }

    public void updateProduct(int id, Products updated) {
        productMap.put(id, updated);
    }

    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    public void displayProducts() {
        for (Products p : productMap.values()) {
            p.display();
        }
    }

    // Searching (Abstraction)
    public List<Products> searchByName(String name) {
        return productMap.values().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Products> searchByCategory(String category) {
        return productMap.values().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Sorting
    public List<Products> sortByName() {
        return productMap.values().stream()
                .sorted(Comparator.comparing(Products::getName))
                .collect(Collectors.toList());
    }

    public List<Products> sortByPrice() {
        return productMap.values().stream()
                .sorted(Comparator.comparingDouble(Products::getPrice))
                .collect(Collectors.toList());
    }

    public List<Products> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
}

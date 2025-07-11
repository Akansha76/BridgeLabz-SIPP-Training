package Ecommmerce.Utils;

import Ecommmerce.model.Products;
import java.util.*;

public class ProductUtils {

    public static void findPairsWithinBudget(List<Products> products, double budget) {
        products.sort(Comparator.comparingDouble(Products::getPrice)); // Sort by price

        int left = 0;
        int right = products.size() - 1;
        boolean found = false;

        while (left < right) {
            double sum = products.get(left).getPrice() + products.get(right).getPrice();

            if (sum == budget) {
                System.out.println("Pair found: ");
                products.get(left).display();
                products.get(right).display();
                found = true;
                left++;
                right--;
            } else if (sum < budget) {
                left++;
            } else {
                right--;
            }
        }

        if (!found) {
            System.out.println("No product pairs found within budget.");
        }
    }
}


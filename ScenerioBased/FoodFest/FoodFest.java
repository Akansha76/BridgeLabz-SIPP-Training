package ScenerioBased.FoodFest;

import java.util.*;

public class FoodFest {

    // Merge Sort wrapper
    public static List<Stall> mergeSort(List<Stall> stalls) {
        if (stalls.size() <= 1) return stalls;

        int mid = stalls.size() / 2;
        List<Stall> left = mergeSort(stalls.subList(0, mid));
        List<Stall> right = mergeSort(stalls.subList(mid, stalls.size()));

        return merge(left, right);
    }

    // Merge two sorted lists (stable)
    private static List<Stall> merge(List<Stall> left, List<Stall> right) {
        List<Stall> result = new ArrayList<>();
        int i = 0, j = 0;

        // Merge while preserving stability
        while (i < left.size() && j < right.size()) {
            if (left.get(i).footfall <= right.get(j).footfall) {
                result.add(left.get(i++)); // stability: left gets picked first if equal
            } else {
                result.add(right.get(j++));
            }
        }

        // Add remaining elements
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    // Display final sorted list
    public static void display(List<Stall> stalls) {
        for (Stall s : stalls) {
            System.out.println("- " + s);
        }
    }

    // Main method to simulate
    public static void main(String[] args) {
        // Pre-sorted zone-wise logs
        List<Stall> zone1 = Arrays.asList(
            new Stall("Chaat Corner", 120),
            new Stall("Dosa Point", 200),
            new Stall("Biryani Hub", 300)
        );

        List<Stall> zone2 = Arrays.asList(
            new Stall("Juice Junction", 150),
            new Stall("Kebab King", 220),
            new Stall("Tandoori Tadka", 280)
        );

        // Combine both zones
        List<Stall> combined = new ArrayList<>();
        combined.addAll(zone1);
        combined.addAll(zone2);

        // Sort using Merge Sort
        List<Stall> sortedStalls = mergeSort(combined);

        System.out.println(" Sorted Stall Footfall:");
        display(sortedStalls);
    }
}

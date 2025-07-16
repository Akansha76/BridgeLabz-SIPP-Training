package ScenerioBased.Bubble;

public class IceCreamRush {

    // Bubble Sort: Descending order of sales
    public static void sortFlavorsByPopularity(Flavor[] flavors) {
        int n = flavors.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization to stop early
            for (int j = 0; j < n - i - 1; j++) {
                if (flavors[j].sales < flavors[j + 1].sales) {
                    // Swap flavors
                    Flavor temp = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // No swaps → already sorted
        }
    }

    // Display flavors
    public static void displayFlavors(Flavor[] flavors) {
        System.out.println("Flavor Sales Ranking:");
        for (Flavor f : flavors) {
            System.out.println("- " + f);
        }
    }

    // Main method
    public static void main(String[] args) {
        Flavor[] flavors = {
            new Flavor("Vanilla", 120),
            new Flavor("Chocolate", 180),
            new Flavor("Strawberry", 90),
            new Flavor("Mango", 150),
            new Flavor("Butterscotch", 130),
            new Flavor("Pista", 70),
            new Flavor("Cookies & Cream", 160),
            new Flavor("Blueberry", 100)
        };

        System.out.println("Before Sorting:\n");
        displayFlavors(flavors);

        sortFlavorsByPopularity(flavors);

        System.out.println("\nAfter Sorting by Popularity:\n");
        displayFlavors(flavors);
    }
}

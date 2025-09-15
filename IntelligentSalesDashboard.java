import java.util.*;
import java.util.stream.*;
import java.time.*;

public class IntelligentSalesDashboard {

    public static void main(String[] args) {
        // Assume cityToStoresMap is already populated
        Map<String, List<Store>> cityToStoresMap = new HashMap<>();

        // Set 60-day filter
        LocalDate cutoff = LocalDate.now().minusDays(60);

        // 1–4: Traverse → filter customers → map to items → flatten
        Stream<Item> allItemsStream = cityToStoresMap.values().stream()
            .flatMap(List::stream) // all stores
            .flatMap(store -> store.getCustomerOrders().entrySet().stream())
            .filter(entry -> {
                // 2. Filter customers with >= 3 orders in last 60 days
                long recentCount = entry.getValue().stream()
                    .filter(order -> order.getOrderDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate().isAfter(cutoff))
                    .count();
                return recentCount >= 3;
            })
            // 3. Map each qualified customer → their orders' items
            .flatMap(entry -> entry.getValue().stream())
            .flatMap(order -> order.getItems().stream());

        // 5–9: distinct, sort, peek, skip, limit, group
        List<Item> topAffordablePicks = allItemsStream
            .distinct() // 5. Remove duplicates (by equals/hashCode of Item)
            .sorted(Comparator.comparingDouble(Item::getPrice).reversed()) // 6
            .peek(item -> System.out.println("Processing: " + item)) // 7
            .skip(2)  // 8. Skip top 2 most expensive
            .limit(10) // next 10
            .collect(Collectors.toList());

        // 9. Group by category
        Map<String, List<Item>> itemsByCategory = topAffordablePicks.stream()
            .collect(Collectors.groupingBy(Item::getCategory));

        // 10. Count Electronics items
        long electronicsCount = itemsByCategory.getOrDefault("Electronics", List.of()).size();

        // 11. anyMatch: any price > $500?
        boolean hasExpensive = topAffordablePicks.stream()
            .anyMatch(item -> item.getPrice() > 500);

        // 12. allMatch: all above $10?
        boolean allAbove10 = topAffordablePicks.stream()
            .allMatch(item -> item.getPrice() > 10);

        // 13. noneMatch: no empty/null names
        boolean noneEmptyNames = topAffordablePicks.stream()
            .noneMatch(item -> item.getName() == null || item.getName().isEmpty());

        // 14. findFirst in "Home Appliances"
        Optional<Item> firstHomeAppliance = itemsByCategory.getOrDefault("Home Appliances", List.of())
            .stream().findFirst();

        // 15. findAny in "Fitness"
        Optional<Item> anyFitness = itemsByCategory.getOrDefault("Fitness", List.of())
            .stream().findAny();

        // 16. reduce() → total value of selected items
        double totalValue = topAffordablePicks.stream()
            .map(Item::getPrice)
            .reduce(0.0, Double::sum);

        // --- Print results ---
        System.out.println("\n=== Dashboard Insights ===");
        System.out.println("Items grouped by category: " + itemsByCategory);
        System.out.println("Electronics count: " + electronicsCount);
        System.out.println("Any > $500? " + hasExpensive);
        System.out.println("All > $10? " + allAbove10);
        System.out.println("No empty names? " + noneEmptyNames);
        System.out.println("First Home Appliance: " + firstHomeAppliance.orElse(null));
        System.out.println("Any Fitness: " + anyFitness.orElse(null));
        System.out.println("Total value of picks: $" + totalValue);
    }
}

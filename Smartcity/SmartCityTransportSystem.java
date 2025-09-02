package Smartcity;

import Smartcity.interfaces.*;
import Smartcity.services.*;
import Smartcity.model.Passenger;
import Smartcity.DashBoard.Dashboard;

import java.util.*;
import java.util.stream.*;

public class SmartCityTransportSystem {
    public static void main(String[] args) {
        // Register services
        List<TransportService> services = Arrays.asList(
            new Busservice(),
            new Metroservice(),
            new Taxiservice(),
            new Ambulanceservice(),
            new EVChargingStation()
        );

        // 1. Dashboard - ForEach + Method Reference
        Dashboard.displayServices(services);

        // 2. Lambda Fare Calculator
        Farecalc calc = (dist, rate) -> dist * rate;
        System.out.println("\nFare (10 km @ rate 7) = " + calc.calculateFare(10, 7));

        // 3. Distance calculation (static method)
        double dist = GeoUtils.calculateDistance(10, 20, 30, 40);
        System.out.println("\nDistance between points = " + dist);

        // 4. Passenger Data
        List<Passenger> passengers = Arrays.asList(
            new Passenger("Alice", "Route1", 20),
            new Passenger("Bob", "Route1", 25),
            new Passenger("Charlie", "Route2", 30),
            new Passenger("David", "Route2", 15),
            new Passenger("Eve", "Route3", 40)
        );

        // 5. Grouping by route
        System.out.println("\n=== Passengers Grouped by Route ===");
        passengers.stream()
            .collect(Collectors.groupingBy(p -> p.route))
            .forEach((route, list) -> System.out.println(route + " -> " +
                list.stream().map(p -> p.name).collect(Collectors.joining(", "))));

        // 6. Summarizing fares
        DoubleSummaryStatistics stats = passengers.stream()
            .collect(Collectors.summarizingDouble(p -> p.fare));
        System.out.println("\nTotal Fare: " + stats.getSum());
        System.out.println("Average Fare: " + stats.getAverage());
        System.out.println("Max Fare: " + stats.getMax());

        // 7. Partitioning passengers
        System.out.println("\n=== Peak vs Non-Peak Trips ===");
        Map<Boolean, List<Passenger>> partitioned = passengers.stream()
            .collect(Collectors.partitioningBy(p -> p.fare > 25));
        System.out.println("Peak (fare > 25): " +
            partitioned.get(true).stream().map(p -> p.name).collect(Collectors.joining(", ")));
        System.out.println("Non-Peak: " +
            partitioned.get(false).stream().map(p -> p.name).collect(Collectors.joining(", ")));

        // 8. Emergency detection
        System.out.println("\n=== Emergency Services ===");
        services.stream()
            .filter(s -> s instanceof EmergencyService)
            .forEach(s -> System.out.println(s.getName() + " is an Emergency Service"));
    }
}

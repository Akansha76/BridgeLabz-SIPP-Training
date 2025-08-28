import java.util.*;
import java.util.stream.*;

// -------- Functional Interface --------
@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance, double ratePerKm);
}

// -------- Marker Interface --------
interface EmergencyService {}

// -------- Base Interface --------
interface TransportService {
    String getName();
    double getFare(double distance);

    // Default method
    default void printServiceDetails() {
        System.out.println("Service: " + getName() + " | Example fare (10 km): " + getFare(10));
    }

    // Static utility method
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Dummy calculation (not real-world haversine)
        return Math.sqrt(Math.pow(lat1 - lat2, 2) + Math.pow(lon1 - lon2, 2)) * 10;
    }
}

// -------- Implementations --------
class BusService implements TransportService {
    private double ratePerKm = 2.0;

    @Override
    public String getName() { return "Bus"; }

    @Override
    public double getFare(double distance) { return ratePerKm * distance; }
}

class MetroService implements TransportService {
    private double ratePerKm = 3.0;

    @Override
    public String getName() { return "Metro"; }

    @Override
    public double getFare(double distance) { return ratePerKm * distance; }
}

class TaxiService implements TransportService {
    private double ratePerKm = 10.0;

    @Override
    public String getName() { return "Taxi"; }

    @Override
    public double getFare(double distance) { return ratePerKm * distance; }
}

class AmbulanceService implements TransportService, EmergencyService {
    private double ratePerKm = 15.0;

    @Override
    public String getName() { return "Ambulance"; }

    @Override
    public double getFare(double distance) { return 0.0; } // Emergency = Free
}

// -------- Passenger Data --------
class Passenger {
    String name;
    String route;
    double fare;

    Passenger(String name, String route, double fare) {
        this.name = name;
        this.route = route;
        this.fare = fare;
    }
}

// -------- Main System --------
public class SmartCityTransportSystem {
    public static void main(String[] args) {
        // Services
        List<TransportService> services = Arrays.asList(
            new BusService(),
            new MetroService(),
            new TaxiService(),
            new AmbulanceService()
        );

        System.out.println("=== Available Services ===");
        services.forEach(TransportService::printServiceDetails); // Method reference

        // Fare Calculator using Lambda
        FareCalculator fareCalc = (dist, rate) -> dist * rate;
        System.out.println("\nFare (10km @ rate 5) = " + fareCalc.calculateFare(10, 5));

        // Distance calculation (static method)
        double dist = TransportService.calculateDistance(10, 20, 30, 40);
        System.out.println("\nDistance between points = " + dist);

        // Passenger Data
        List<Passenger> passengers = Arrays.asList(
            new Passenger("Alice", "Route1", 20),
            new Passenger("Bob", "Route1", 25),
            new Passenger("Charlie", "Route2", 30),
            new Passenger("David", "Route2", 15),
            new Passenger("Eve", "Route3", 40)
        );

        // Grouping passengers by route
        System.out.println("\n=== Passengers Grouped by Route ===");
        Map<String, List<Passenger>> grouped = passengers.stream()
                .collect(Collectors.groupingBy(p -> p.route));
        grouped.forEach((route, list) -> {
            System.out.println(route + " -> " +
                    list.stream().map(p -> p.name).collect(Collectors.joining(", ")));
        });

        // Summarizing fares
        DoubleSummaryStatistics stats = passengers.stream()
                .collect(Collectors.summarizingDouble(p -> p.fare));
        System.out.println("\nTotal Fare Collected: " + stats.getSum());
        System.out.println("Average Fare: " + stats.getAverage());
        System.out.println("Max Fare: " + stats.getMax());

        // Partitioning (peak vs non-peak)
        System.out.println("\n=== Peak vs Non-Peak Trips ===");
        Map<Boolean, List<Passenger>> partitioned = passengers.stream()
                .collect(Collectors.partitioningBy(p -> p.fare > 25));
        System.out.println("Peak (fare > 25): " +
                partitioned.get(true).stream().map(p -> p.name).collect(Collectors.joining(", ")));
        System.out.println("Non-Peak: " +
                partitioned.get(false).stream().map(p -> p.name).collect(Collectors.joining(", ")));

        // Detect Emergency Services
        System.out.println("\n=== Emergency Services ===");
        services.stream()
                .filter(s -> s instanceof EmergencyService)
                .forEach(s -> System.out.println(s.getName() + " is an Emergency Service"));
    }
}


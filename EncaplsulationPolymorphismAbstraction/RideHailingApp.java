package EncaplsulationPolymorphismAbstraction;

import java.util.*;

// 1. Abstract Class: Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }

    // Encapsulated getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    // Allow update only through interface
    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + " | Driver: " + driverName + " | Rate: Rs. " + ratePerKm + " per km";
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}

// 2. Interface: GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// 3a. Car Class
class Car extends Vehicle implements GPS {
    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // base fare Rs.50
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// 3b. Bike Class
class Bike extends Vehicle implements GPS {
    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // no base fare
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// 3c. Auto Class
class Auto extends Vehicle implements GPS {
    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 30; // base fare Rs.30
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// 4. Ride Manager (Polymorphic Fare Calculator)
class RideManager {
    public static void processRides(List<Vehicle> vehicles, double distance) {
        System.out.println("Ride Fare Summary for distance: " + distance + " km");
        

        for (Vehicle v : vehicles) {
            System.out.println(v.getVehicleDetails());
            System.out.println("Location: " + v.getCurrentLocation());
            System.out.println("Total Fare: Rs. " + v.calculateFare(distance));
            System.out.println();
        }
    }
}

// 5. Main Class
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rideOptions = new ArrayList<>();

        Car car1 = new Car("CAR101", "Ramesh", 12.5);
        Bike bike1 = new Bike("BIKE201", "Amit", 7.0);
        Auto auto1 = new Auto("AUTO301", "Suresh", 9.0);

        // Update locations using GPS interface
        car1.updateLocation("City Center");
        bike1.updateLocation("MG Road");
        auto1.updateLocation("Railway Station");

        // Add to list
        rideOptions.add(car1);
        rideOptions.add(bike1);
        rideOptions.add(auto1);

        // Polymorphic processing
        RideManager.processRides(rideOptions, 10); // Example: 10 km ride
    }
}


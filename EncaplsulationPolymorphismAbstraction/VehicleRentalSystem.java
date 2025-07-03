package EncaplsulationPolymorphismAbstraction;

import java.util.*;

// 1. Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber; // Encapsulated

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Encapsulated access to insurance policy number
    protected void setInsurancePolicyNumber(String policy) {
        this.insurancePolicyNumber = policy;
    }

    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle No: " + vehicleNumber + " | Type: " + type + " | Rate per day: Rs. " + rentalRate;
    }
}

// 2. Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// 3a. Car class
class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) {
        super(number, "Car", rate);
        setInsurancePolicyNumber("CAR-INS-12345");
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 5000.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy No: " + getInsurancePolicyNumber() + " | Premium: Rs. " + calculateInsurance();
    }
}

// 3b. Bike class
class Bike extends Vehicle implements Insurable {
    public Bike(String number, double rate) {
        super(number, "Bike", rate);
        setInsurancePolicyNumber("BIKE-INS-67890");
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1200.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy No: " + getInsurancePolicyNumber() + " | Premium: Rs. " + calculateInsurance();
    }
}

// 3c. Truck class
class Truck extends Vehicle implements Insurable {
    public Truck(String number, double rate) {
        super(number, "Truck", rate);
        setInsurancePolicyNumber("TRUCK-INS-34567");
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000; // Additional handling charge
    }

    @Override
    public double calculateInsurance() {
        return 8000.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy No: " + getInsurancePolicyNumber() + " | Premium: Rs. " + calculateInsurance();
    }
}

// 4. Rental Manager
class RentalManager {
    public static void showRentalSummary(List<Vehicle> vehicles, int days) {
        System.out.println("Rental Summary for " + days + " days");
       
        for (Vehicle v : vehicles) {
            System.out.println(v.getVehicleDetails());
            System.out.println("Rental Cost: Rs. " + v.calculateRentalCost(days));

            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                System.out.println(i.getInsuranceDetails());
            }

            System.out.println();
        }
    }
}

// 5. Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> rentedVehicles = new ArrayList<>();

        Car car = new Car("MH12AB1234", 1500);
        Bike bike = new Bike("MH14XY4567", 500);
        Truck truck = new Truck("MH10ZZ9999", 2500);

        rentedVehicles.add(car);
        rentedVehicles.add(bike);
        rentedVehicles.add(truck);

        RentalManager.showRentalSummary(rentedVehicles, 5); // Rent duration = 5 days
    }
}

public class VehicleManagement {

    // Superclass
    static class Vehicle {
        String model;
        int maxSpeed;

        public Vehicle(String model, int maxSpeed) {
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        public void showDetails() {
            System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
        }
    }

    // Interface
    interface Refuelable {
        void refuel();
    }

    // Subclass: ElectricVehicle
    static class ElectricVehicle extends Vehicle {
        int batteryLevel;

        public ElectricVehicle(String model, int maxSpeed, int batteryLevel) {
            super(model, maxSpeed);
            this.batteryLevel = batteryLevel;
        }

        public void charge() {
            batteryLevel = 100;
            System.out.println("Electric vehicle charged to 100%.");
        }

        public void displayStatus() {
            showDetails();
            System.out.println("Battery Level: " + batteryLevel + "%");
        }
    }

    // Subclass: PetrolVehicle (Hybrid Inheritance)
    static class PetrolVehicle extends Vehicle implements Refuelable {
        int fuelLevel;

        public PetrolVehicle(String model, int maxSpeed, int fuelLevel) {
            super(model, maxSpeed);
            this.fuelLevel = fuelLevel;
        }

        @Override
        public void refuel() {
            fuelLevel = 100;
            System.out.println("Petrol vehicle refueled to 100%.");
        }

        public void displayStatus() {
            showDetails();
            System.out.println("Fuel Level: " + fuelLevel + "%");
        }
    }

    // Main method
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 75);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 60);

        System.out.println("=== Electric Vehicle ===");
        ev.displayStatus();
        ev.charge();
        ev.displayStatus();

        System.out.println("\n=== Petrol Vehicle ===");
        pv.displayStatus();
        pv.refuel();
        pv.displayStatus();
    }
}

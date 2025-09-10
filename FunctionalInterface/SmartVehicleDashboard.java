package FunctionalInterface;

interface Vehicle {
    void displaySpeed(int speed);

    // New default method for EVs
    default void displayBattery(int batteryPercentage) {
        System.out.println("Battery info not available for this vehicle.");
    }
}

class Car implements Vehicle {
    @Override
    public void displaySpeed(int speed) {
        System.out.println("Car Speed: " + speed + " km/h");
    }
}

class ElectricCar implements Vehicle {
    @Override
    public void displaySpeed(int speed) {
        System.out.println("EV Speed: " + speed + " km/h");
    }

    @Override
    public void displayBattery(int batteryPercentage) {
        System.out.println("Battery: " + batteryPercentage + "%");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle ev = new ElectricCar();

        car.displaySpeed(80);
        car.displayBattery(0); // uses default

        ev.displaySpeed(120);
        ev.displayBattery(85); // overridden
    }
}

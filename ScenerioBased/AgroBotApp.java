package ScenerioBased;
// SensorReadable Interface
interface SensorReadable {
    void readSensorData();
}

// Abstract Base Class
abstract class IrrigationUnit implements SensorReadable {
    private double waterPressure;

    // Constructor
    public IrrigationUnit(double pressure) {
        this.waterPressure = pressure;
        calibrate();  // Private method called internally
    }

    // Abstraction - common behavior
    public void stopWatering() {
        System.out.println("Watering stopped.");
    }

    // Abstract method to be overridden
    public abstract void startWatering();

    // Private method - cannot be accessed from child classes
    private void calibrate() {
        System.out.println("Calibrating system with water pressure: " + waterPressure + " PSI");
    }
}

// Sprinkler Unit - uses constructor chaining
class Sprinkler extends IrrigationUnit {
    public Sprinkler() {
        super(25.0); // Constructor chaining to IrrigationUnit
    }

    @Override
    public void startWatering() {
        System.out.println("Sprinkler system started spraying water.");
    }

    @Override
    public void readSensorData() {
        System.out.println("Sprinkler reading soil moisture sensor...");
    }
}

// Drip System - another subclass
class DripSystem extends IrrigationUnit {
    public DripSystem() {
        super(15.0); // Constructor chaining
    }

    @Override
    public void startWatering() {
        System.out.println("Drip system started releasing water drop by drop.");
    }

    @Override
    public void readSensorData() {
        System.out.println("Drip system reading temperature and humidity sensors...");
    }
}

// Main class to demonstrate Polymorphism
public class AgroBotApp {
    public static void main(String[] args) {
        IrrigationUnit unit1 = new Sprinkler();  // Polymorphism
        IrrigationUnit unit2 = new DripSystem();

        unit1.readSensorData();     // Interface method
        unit1.startWatering();      // Overridden method
        unit1.stopWatering();       // Inherited method

        System.out.println();

        unit2.readSensorData();
        unit2.startWatering();
        unit2.stopWatering();
    }
}


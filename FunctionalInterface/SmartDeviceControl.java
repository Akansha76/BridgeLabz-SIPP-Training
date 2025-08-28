package FunctionalInterface;
// Interface
interface SmartDevice {
    void turnOn();
    void turnOff();
}

// Implementations
class Light implements SmartDevice {
    public void turnOn() { System.out.println("💡 Light is ON"); }
    public void turnOff() { System.out.println("💡 Light is OFF"); }
}

class AirConditioner implements SmartDevice {
    public void turnOn() { System.out.println("❄️ AC is ON"); }
    public void turnOff() { System.out.println("❄️ AC is OFF"); }
}

class Television implements SmartDevice {
    public void turnOn() { System.out.println("📺 TV is ON"); }
    public void turnOff() { System.out.println("📺 TV is OFF"); }
}

public class SmartDeviceControl {
    public static void main(String[] args) {
        SmartDevice light = new Light();
        SmartDevice ac = new AirConditioner();
        SmartDevice tv = new Television();

        light.turnOn(); light.turnOff();
        ac.turnOn(); ac.turnOff();
        tv.turnOn(); tv.turnOff();
    }
}

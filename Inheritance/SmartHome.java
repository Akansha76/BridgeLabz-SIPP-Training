public class SmartHome {
    
    static class Device {
        private String deviceId;
        private boolean status; // true = ON, false = OFF

        public Device(String deviceId, boolean status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        public void displayStatus() {
            String state = status ? "ON" : "OFF";
            System.out.println("Device ID: " + deviceId + " | Status: " + state);
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    // Subclass: specific device - Thermostat
    static class Thermostat extends Device {
        private double temperatureSetting;

        public Thermostat(String deviceId, boolean status, double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        @Override
        public void displayStatus() {
            super.displayStatus();
            System.out.println("   Temperature Setting: " + temperatureSetting + "°C");
        }

        public void setTemperatureSetting(double temperatureSetting) {
            this.temperatureSetting = temperatureSetting;
        }
    }

    
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("T001", true, 24.5);
        t1.displayStatus();

        System.out.println();

        t1.setStatus(false);
        t1.setTemperatureSetting(21.0);
        t1.displayStatus();
    }
}

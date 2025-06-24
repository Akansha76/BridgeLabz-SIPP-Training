package ConstructorInstanceModifiers.level1;

public class Vehicle {
    String ownerName;
    String vehicleType;

    private static double registrationFee = 1000.0;

    void displayVehicleDetails(String ownerName, String vehicleType,int registrationFee) {

        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to ₹" + registrationFee);
    }
    public static void main(String[] args) {
        Vehicle v1= new Vehicle();
        v1.displayVehicleDetails("Raju","motor",  0);
        System.out.println("Owner Name: " + v1.ownerName + ", Vehicle Type: " + v1.vehicleType+",Registration fee "+v1.registrationFee);

        v1.updateRegistrationFee(1200.0);
        System.out.println("Owner Name: " + v1.ownerName + ", Vehicle Type: " + v1.vehicleType+",Registration fee "+v1.registrationFee);
    }
}

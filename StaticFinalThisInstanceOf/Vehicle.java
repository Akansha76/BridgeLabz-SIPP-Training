public class Vehicle {

    // 1. STATIC MEMBERS
    private static double registrationFee = 1500.00;
    
    // 3. FINAL VARIABLE
    private final String registrationNumber;

    // INSTANCE VARIABLES
    private String ownerName;
    private String vehicleType;

    // 2. Constructor using 'this'
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to ₹" + newFee);
    }

    // Display vehicle details (with instanceof check)
    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\n--- Vehicle Registration Details ---");
            System.out.println("Owner Name        : " + ownerName);
            System.out.println("Vehicle Type      : " + vehicleType);
            System.out.println("Registration No.  : " + registrationNumber);
            System.out.printf("Registration Fee  : ₹%.2f%n", registrationFee);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Akanksha", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("John", "Bike", "DL08XY7890");

        v1.displayDetails();
        v2.displayDetails();

        // Update registration fee
        updateRegistrationFee(2000.00);

        // Show updated details
        v1.displayDetails();
        v2.displayDetails();
    }
}


public class Patient {

    // 1. Static
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    // 2. Final
    final int patientID;

    // 3. Instance variables
    String name;
    int age;
    String ailment;

    // Constructor using 'this' and assigning unique ID
    public Patient(int id, String name, int age, String ailment) {
        this.patientID = id;        // final variable initialized
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;            // Increment count when a new patient is created
    }

    // 4. Static method to get total patients
    static int getTotalPatients() {
        return totalPatients;
    }

    // Method to display patient details using instanceof
    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
          
        }
    }

    // Main method to test functionality
    public static void main(String[] args) {
        Patient p1 = new Patient(101, "Alice", 30, "Flu");
        Patient p2 = new Patient(102, "Bob", 45, "Diabetes");

        p1.displayDetails();
        p2.displayDetails();

        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
    }
}

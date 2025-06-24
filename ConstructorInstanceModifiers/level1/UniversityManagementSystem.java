package ConstructorInstanceModifiers.level1;

// Base class: Student
class Student {
    public int rollNumber;         // Public: accessible from anywhere
    protected String name;         // Protected: accessible within package and subclasses
    private double CGPA;           // Private: accessible only within this class

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Must be between 0.0 and 10.0");
        }
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass: PostgraduateStudent
class PostgraduateStudent extends Student {

    private String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateInfo() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);         // public member from superclass
        System.out.println("Name: " + name);                      // protected member from superclass
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA: " + getCGPA());                 // private member accessed via public method
    }
}

// Main class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Anjali Sharma", 8.6, "Data Science");

        // Display postgraduate student details
        pgStudent.displayPostgraduateInfo();

        // Modify CGPA using public method
        pgStudent.setCGPA(9.1);
        System.out.println("\nAfter updating CGPA:");
        pgStudent.displayPostgraduateInfo();
    }
}


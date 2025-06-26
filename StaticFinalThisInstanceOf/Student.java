
public class Student {

    // 1. STATIC MEMBERS
    private static String universityName = "ABC University";
    private static int totalStudents = 0;

    // 3. FINAL VARIABLE
    private final int rollNumber;

    // INSTANCE VARIABLES
    private String name;
    private String grade;

    // 2. Constructor using 'this'
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // 4. Method to display student details (with instanceof check)
    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("\n--- Student Details ---");
            System.out.println("University : " + universityName);
            System.out.println("Name       : " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade      : " + grade);
        }
    }

    // Method to update grade (with instanceof check)
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        }
    }

    // Static method to show total students
    public static void displayTotalStudents() {
        System.out.println("\nTotal Students Enrolled: " + totalStudents);
    }

    // Main method to test the Student class
    public static void main(String[] args) {
        Student s1 = new Student("Akanksha", 101, "A");
        Student s2 = new Student("Rahul", 102, "B");

        s1.displayDetails();
        s2.displayDetails();

        s2.updateGrade("A+");

        s2.displayDetails();

        Student.displayTotalStudents();
    }
}


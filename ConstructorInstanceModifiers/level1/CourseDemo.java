package ConstructorInstanceModifiers.level1;
// Course.java
class Course {
    private String courseName;
    private int duration; // in weeks
    private double fee;
    private static String instituteName = "Tech Institute"; // Shared by all courses

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }
}

public class CourseDemo {
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 6, 8000);
        Course c2 = new Course("Web Development", 8, 10000);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
        System.out.println();

        // Update institute name using class method
        Course.updateInstituteName("SkillUp Academy");

        System.out.println("\nAfter Updating Institute Name:\n");

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}

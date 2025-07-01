import java.util.ArrayList;

public class SchoolAssociationAggregationDemo {

    /* ---------- Course Class (shared across students) ---------- */
    static class Course {
        private final String courseName;
        private final ArrayList<Student> enrolledStudents;

        public Course(String courseName) {
            this.courseName = courseName;
            this.enrolledStudents = new ArrayList<>();
        }

        public String getCourseName() {
            return courseName;
        }

        public void enrollStudent(Student student) {
            if (!enrolledStudents.contains(student)) {
                enrolledStudents.add(student);
                student.addCourse(this);  // Association: bidirectional
            }
        }

        public void showEnrolledStudents() {
            System.out.println("\n Course: " + courseName);
            if (enrolledStudents.isEmpty()) {
                System.out.println("   — no students enrolled —");
            } else {
                for (Student s : enrolledStudents) {
                    System.out.println(s.getName());
                }
            }
        }
    }

    /* ---------- Student Class (can be part of many courses) ---------- */
    static class Student {
        private final String name;
        private final ArrayList<Course> enrolledCourses;

        public Student(String name) {
            this.name = name;
            this.enrolledCourses = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        // Called only by Course to maintain bidirectional association
        public void addCourse(Course course) {
            if (!enrolledCourses.contains(course)) {
                enrolledCourses.add(course);
            }
        }

        public void viewCourses() {
            System.out.println("\n Student: " + name);
            if (enrolledCourses.isEmpty()) {
                System.out.println("   — not enrolled in any course —");
            } else {
                for (Course c : enrolledCourses) {
                    System.out.println( c.getCourseName());
                }
            }
        }
    }

    /* ---------- School Class (aggregates Students) ---------- */
    static class School {
        private final String name;
        private final ArrayList<Student> students;

        public School(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);  // Aggregation: School contains students, but they can exist outside too
        }

        public void showAllStudents() {
            System.out.println("\n School: " + name + " — Student List");
            if (students.isEmpty()) {
                System.out.println("   — no students —");
            } else {
                for (Student s : students) {
                    System.out.println(s.getName());
                }
            }
        }
    }

    /* ---------- Main Method ---------- */
    public static void main(String[] args) {
        // Create a school
        School sunriseHigh = new School("Sunrise High School");

        // Create students
        Student akanksha = new Student("Akanksha");
        Student rahul = new Student("Rahul");
        Student maya = new Student("Maya");

        // Aggregation: add students to the school
        sunriseHigh.addStudent(akanksha);
        sunriseHigh.addStudent(rahul);
        sunriseHigh.addStudent(maya);

        // Create courses
        Course math = new Course("Mathematics");
        Course sci = new Course("Science");
        Course eng = new Course("English");

        // Association (many-to-many)
        math.enrollStudent(akanksha);
        math.enrollStudent(rahul);

        sci.enrollStudent(akanksha);
        sci.enrollStudent(maya);

        eng.enrollStudent(rahul);
        eng.enrollStudent(maya);

        // Show students in each course
        math.showEnrolledStudents();
        sci.showEnrolledStudents();
        eng.showEnrolledStudents();

        // Each student views their enrolled courses
        akanksha.viewCourses();
        rahul.viewCourses();
        maya.viewCourses();

        // Show all students in school
        sunriseHigh.showAllStudents();
    }
}

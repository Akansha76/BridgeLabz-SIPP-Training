import java.util.ArrayList;

public class UniversityManagementDemo {

    static class Course {
        private final String name;
        private final ArrayList<Student> students = new ArrayList<>();
        private Professor professor;

        public Course(String name) {
            this.name = name;
        }

        public void assignProfessor(Professor p) {
            this.professor = p;
            System.out.println(p.getName() + " assigned to " + name);
        }

        public void enrollStudent(Student s) {
            if (!students.contains(s)) {
                students.add(s);
                s.addCourse(this);
                System.out.println("🎓 " + s.getName() + " enrolled in " + name);
            }
        }

        public void showInfo() {
            System.out.println("\n Course: " + name);
            System.out.println("Professor: " + (professor != null ? professor.getName() : "None"));
            System.out.println(" Students:");
            for (Student s : students) {
                System.out.println("• " + s.getName());
            }
        }
    }

    static class Student {
        private final String name;
        private final ArrayList<Course> enrolledCourses = new ArrayList<>();

        public Student(String name) {
            this.name = name;
        }

        public String getName() { return name; }

        public void addCourse(Course c) {
            enrolledCourses.add(c);
        }

        public void showCourses() {
            System.out.println("\n🎓 " + name + " enrolled in:");
            for (Course c : enrolledCourses) {
                System.out.println("• " + c.name);
            }
        }
    }

    static class Professor {
        private final String name;

        public Professor(String name) {
            this.name = name;
        }

        public String getName() { return name; }
    }

    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Sharma");
        Professor prof2 = new Professor("Dr. Iyer");

        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        Student s1 = new Student("Akanksha");
        Student s2 = new Student("Rahul");

        c1.assignProfessor(prof1);
        c2.assignProfessor(prof2);

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s1);

        c1.showInfo();
        c2.showInfo();

        s1.showCourses();
        s2.showCourses();
    }
}

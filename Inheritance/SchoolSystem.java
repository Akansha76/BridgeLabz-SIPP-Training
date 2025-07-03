public class SchoolSystem {

    // Superclass: Person
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    // Subclass: Teacher
    static class Teacher extends Person {
        String subject;

        public Teacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }

        public void displayRole() {
            displayInfo();
            System.out.println("Role: Teacher");
            System.out.println("Teaches: " + subject);
        }
    }

    // Subclass: Student
    static class Student extends Person {
        int grade;

        public Student(String name, int age, int grade) {
            super(name, age);
            this.grade = grade;
        }

        public void displayRole() {
            displayInfo();
            System.out.println("Role: Student");
            System.out.println("Grade: " + grade);
        }
    }

    // Subclass: Staff
    static class Staff extends Person {
        String department;

        public Staff(String name, int age, String department) {
            super(name, age);
            this.department = department;
        }

        public void displayRole() {
            displayInfo();
            System.out.println("Role: Staff");
            System.out.println("Department: " + department);
        }
    }

    
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Riya", 16, 10);
        Staff staff = new Staff("Anita", 35, "Administration");

        System.out.println("=== Teacher Info ===");
        teacher.displayRole();

        System.out.println("\n=== Student Info ===");
        student.displayRole();

        System.out.println("\n=== Staff Info ===");
        staff.displayRole();
    }
}

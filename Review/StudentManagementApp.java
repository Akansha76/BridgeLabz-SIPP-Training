import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private double grade; // e.g., GPA or percentage

    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and setters (only getters used in this example)
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', age=%d, grade=%.2f}", id, name, age, grade);
    }
}

class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student s) {
        students.add(s);
    }

    // Remove by id, returns true if removed
    public boolean removeStudentById(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    // Search by id
    public Optional<Student> findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    // List all students sorted by name
    public ArrayList<Student> listSortedByName() {
        ArrayList<Student> copy = new ArrayList<>(students);
        copy.sort(Comparator.comparing(Student::getName));
        return copy;
    }

    // Average age
    public double averageAge() {
        if (students.isEmpty()) return 0.0;
        double sum = students.stream().mapToDouble(Student::getAge).sum();
        return sum / students.size();
    }

    public int count() {
        return students.size();
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentManager mgr = new StudentManager();

        // Preload some students
        mgr.addStudent(new Student(1, "Asha", 17, 85.5));
        mgr.addStudent(new Student(2, "Ravi", 18, 78.0));
        mgr.addStudent(new Student(3, "Neha", 17, 91.2));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Manager ---");
            System.out.println("1. Add student");
            System.out.println("2. Remove student by ID");
            System.out.println("3. Find student by ID");
            System.out.println("4. List students (sorted by name)");
            System.out.println("5. Show average age & count");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = -1;
            try { choice = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { /* ignore */ }

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Grade: ");
                    double grade = Double.parseDouble(sc.nextLine().trim());
                    mgr.addStudent(new Student(id, name, age, grade));
                    System.out.println("Added.");
                }
                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    boolean removed = mgr.removeStudentById(id);
                    System.out.println(removed ? "Removed." : "No student with that ID.");
                }
                case 3 -> {
                    System.out.print("Enter ID to find: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Optional<Student> s = mgr.findById(id);
                    System.out.println(s.map(Student::toString).orElse("Not found."));
                }
                case 4 -> {
                    System.out.println("Students sorted by name:");
                    for (Student s : mgr.listSortedByName()) {
                        System.out.println(s);
                    }
                }
                case 5 -> {
                    System.out.printf("Count = %d, Average age = %.2f\n", mgr.count(), mgr.averageAge());
                }
                case 6 -> {
                    running = false;
                    System.out.println("Bye!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}

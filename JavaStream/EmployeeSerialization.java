import java.io.*;
import java.util.*;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // For version control

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // toString() for displaying employee details
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class EmployeeSerialization {
    private static final String FILE_PATH = "D:/Collection/JavaStream/employees.ser";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        try {
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            // Take employee details
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Employee " + (i + 1) + ":");
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String dept = sc.nextLine();

                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine(); // consume newline

                employees.add(new Employee(id, name, dept, salary));
            }

            // Serialize the list of employees
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                oos.writeObject(employees);
                System.out.println("\n Employees saved successfully to " + FILE_PATH);
            }

            // Deserialize the list of employees
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                List<Employee> deserializedList = (List<Employee>) ois.readObject();
                System.out.println("\n Retrieved Employees from File:");
                for (Employee emp : deserializedList) {
                    System.out.println(emp);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

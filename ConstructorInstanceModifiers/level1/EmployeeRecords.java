package ConstructorInstanceModifiers.level1;

// Base class: Employee
class Employee {
    public int employeeID;         // Public: accessible everywhere
    protected String department;   // Protected: accessible in subclass
    private double salary;         // Private: accessible only within this class

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to set salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive.");
        }
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Method to display employee info
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    private int teamSize;

    // Constructor
    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    // Display manager-specific info
    public void displayManagerInfo() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID);      // public
        System.out.println("Department: " + department);       // protected
        System.out.println("Salary: ₹" + getSalary());         // private accessed via public method
        System.out.println("Team Size: " + teamSize);
    }
}

// Main class
public class EmployeeRecords {
    public static void main(String[] args) {
        // Create a Manager object
        Manager mgr = new Manager(501, "Engineering", 75000, 8);

        // Display initial info
        mgr.displayManagerInfo();

        // Update salary
        mgr.setSalary(85000);

        System.out.println("\nAfter Salary Update:");
        mgr.displayManagerInfo();
    }
}

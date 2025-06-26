public class Employee {

    // 1. STATIC MEMBERS
    private static String companyName = "BridgeLabz Pvt Ltd";
    private static int totalEmployees = 0;

    // 3. FINAL VARIABLE
    private final int id;  // Employee ID can't be changed

    // INSTANCE VARIABLES
    private String name;
    private String designation;

    // 2. CONSTRUCTOR using 'this'
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;  // Count every new employee
    }

    // INSTANCE METHOD
    public void showDetails() {
        // 4. instanceof check
        if (this instanceof Employee) {
            System.out.println("\n--- Employee Details ---");
            System.out.println("Company    : " + companyName);
            System.out.println("ID         : " + id);
            System.out.println("Name       : " + name);
            System.out.println("Designation: " + designation);
        }
    }

    // STATIC METHOD
    public static void displayTotalEmployees() {
        System.out.println("\nTotal Employees: " + totalEmployees);
    }

    // MAIN METHOD to test
    public static void main(String[] args) {
        Employee e1 = new Employee("Akanksha Shakya", 101, "Software Engineer");
        Employee e2 = new Employee("John Doe", 102, "Team Lead");

        e1.showDetails();
        e2.showDetails();

        Employee.displayTotalEmployees();
    }
}

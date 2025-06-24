
public class Employee {
    // instance variables
    String name;
    int id;
    double salary;

    // constructor
    Employee(String name, int id, double salary) {
        this.name = name;     
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: ₹" + salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Akanksha", 101, 50000);
        Employee e2 = new Employee("Ravi", 102, 60000);

        e1.displayDetails();
        e2.displayDetails();
    }
}

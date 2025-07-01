import java.util.ArrayList;

public class CompanyCompositionDemo {

    /* ---------- Employee (INNER to Department) ---------- */
    static class Employee {
        private final String name;
        private final String position;

        public Employee(String name, String position) {
            this.name = name;
            this.position = position;
        }

        public void display() {
            System.out.println( name + " — " + position);
        }
    }

    /* ---------- Department (owned by Company) ---------- */
    static class Department {
        private final String name;
        private final ArrayList<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(String name, String position) {
            employees.add(new Employee(name, position));
        }

        public void display() {
            System.out.println("\n Department: " + name);
            if (employees.isEmpty()) {
                System.out.println("   — no employees —");
            } else {
                for (Employee emp : employees) {
                    emp.display();
                }
            }
        }

        public void clearEmployees() {
            employees.clear();
        }
    }

    /* ---------- Company (composes Departments) ---------- */
    static class Company {
        private final String name;
        private final ArrayList<Department> departments;

        public Company(String name) {
            this.name = name;
            this.departments = new ArrayList<>();
        }

        public Department addDepartment(String deptName) {
            Department dept = new Department(deptName);
            departments.add(dept);
            return dept;
        }

        public void showStructure() {
            System.out.println("\n Company: " + name);
            if (departments.isEmpty()) {
                System.out.println("   — no departments —");
            } else {
                for (Department dept : departments) {
                    dept.display();
                }
            }
        }

        public void dissolveCompany() {
            // Simulate cleanup
            for (Department dept : departments) {
                dept.clearEmployees();
            }
            departments.clear();
            System.out.println("\n Company \"" + name + "\" and all departments/employees removed.");
        }
    }

    /* ---------- Main Demo ---------- */
    public static void main(String[] args) {
        Company techCorp = new Company("TechCorp");

        // Create departments and add employees
        Department dev = techCorp.addDepartment("Development");
        dev.addEmployee("Alice", "Software Engineer");
        dev.addEmployee("Bob", "Backend Developer");

        Department hr = techCorp.addDepartment("Human Resources");
        hr.addEmployee("Carol", "HR Manager");

        // Show initial structure
        techCorp.showStructure();

        // Dissolve company — simulate composition cleanup
        techCorp.dissolveCompany();

        // Try showing structure again (should be empty)
        techCorp.showStructure();
    }
}

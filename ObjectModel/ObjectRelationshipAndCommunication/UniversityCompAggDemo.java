import java.util.ArrayList;
import java.util.List;

public class UniversityCompAggDemo {

    /* ---------- Faculty (aggregated to University, may stand alone) ---------- */
    static class Faculty {
        private final String name;
        private String departmentName;      // optional – null if unattached

        public Faculty(String name) {
            this.name = name;
        }

        void assignToDepartment(String deptName) {   // called by Department
            this.departmentName = deptName;
        }

        public String getName() { return name; }

        public void showInfo() {
            System.out.println( name +
                    (departmentName == null ? " (no department)" : " — " + departmentName));
        }
    }

    /* ---------- Department (composed inside University) ---------- */
    static class Department {
        private final String name;
        private final List<Faculty> facultyList = new ArrayList<>();

        Department(String name) { this.name = name; }

        void addFaculty(Faculty f) {
            facultyList.add(f);
            f.assignToDepartment(name);
        }

        void showDepartment() {
            System.out.println("\n Department: " + name);
            if (facultyList.isEmpty()) {
                System.out.println("   — no faculty —");
            } else {
                facultyList.forEach(Faculty::showInfo);
            }
        }

        void clearFaculty() { facultyList.clear(); }
    }

    /* ---------- University (owns Departments; aggregates Faculty) ---------- */
    static class University {
        private final String name;
        private final List<Department> departments = new ArrayList<>();
        private final List<Faculty> facultyPool = new ArrayList<>();   // aggregation

        University(String name) { this.name = name; }

        Department createDepartment(String deptName) {
            Department d = new Department(deptName);
            departments.add(d);
            return d;
        }

        void hireFaculty(Faculty f) {    // Faculty exists outside; we simply keep a reference
            facultyPool.add(f);
        }

        void showStructure() {
            System.out.println("\n University: " + name);
            if (departments.isEmpty()) {
                System.out.println("   — no departments —");
            } else {
                departments.forEach(Department::showDepartment);
            }
            System.out.println("\n Faculty Pool (aggregation – may or may not belong to a department):");
            if (facultyPool.isEmpty()) {
                System.out.println("   — no faculty hired —");
            } else {
                facultyPool.forEach(Faculty::showInfo);
            }
        }

        /* Composition cleanup: destroy departments (but NOT faculty pool) */
        void dissolve() {
            departments.forEach(Department::clearFaculty); // clear any references
            departments.clear();
            System.out.println("\n University \"" + name + "\" dissolved – all departments removed.");
        }
    }

    /* ---------- Demo ---------- */
    public static void main(String[] args) {

        // 1. Create a university.
        University globalUni = new University("Global University");

        // 2. Create departments (composition).
        Department cs   = globalUni.createDepartment("Computer Science");
        Department math = globalUni.createDepartment("Mathematics");

        // 3. Create faculty (aggregation – can exist first, then be hired/assigned).
        Faculty profAlice = new Faculty("Alice");
        Faculty profBob   = new Faculty("Bob");
        Faculty profCara  = new Faculty("Cara");   // will remain without department

        // 4. Hire faculty to university (aggregation).
        globalUni.hireFaculty(profAlice);
        globalUni.hireFaculty(profBob);
        globalUni.hireFaculty(profCara);

        // 5. Assign some faculty to departments (many‑to‑one within university).
        cs.addFaculty(profAlice);
        math.addFaculty(profBob);
        // profCara stays unattached to any department.

        // 6. Show initial structure.
        globalUni.showStructure();

        // 7. Dissolve university – composition cleanup.
        globalUni.dissolve();

        // 8. Show structure after dissolution.
        globalUni.showStructure();   // no departments, faculty still in pool

        // 9. Prove faculty still exist independently.
        System.out.println("\n Faculty objects still alive after university dissolution:");
        profAlice.showInfo();
        profCara.showInfo();
    }
}


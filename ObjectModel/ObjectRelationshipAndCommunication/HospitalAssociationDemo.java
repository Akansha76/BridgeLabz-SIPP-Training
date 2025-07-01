import java.util.ArrayList;

public class HospitalAssociationDemo {

    static class Patient {
        private final String name;
        private final ArrayList<Doctor> consultedDoctors = new ArrayList<>();

        public Patient(String name) {
            this.name = name;
        }

        public String getName() { return name; }

        public void addDoctor(Doctor d) {
            if (!consultedDoctors.contains(d)) consultedDoctors.add(d);
        }

        public void showConsultedDoctors() {
            System.out.println("\n Patient: " + name + " consulted:");
            for (Doctor d : consultedDoctors) {
                System.out.println(d.getName());
            }
        }
    }

    static class Doctor {
        private final String name;
        private final ArrayList<Patient> patientsSeen = new ArrayList<>();

        public Doctor(String name) {
            this.name = name;
        }

        public String getName() { return name; }

        public void consult(Patient p) {
            System.out.println(" Consultation: Dr. " + name + " consulted " + p.getName());
            if (!patientsSeen.contains(p)) patientsSeen.add(p);
            p.addDoctor(this);
        }

        public void showPatients() {
            System.out.println("\n Dr. " + name + " consulted:");
            for (Patient p : patientsSeen) {
                System.out.println( p.getName());
            }
        }
    }

    public static void main(String[] args) {
        Doctor d1 = new Doctor("Smith");
        Doctor d2 = new Doctor("Jones");

        Patient p1 = new Patient("Akanksha");
        Patient p2 = new Patient("Rahul");

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        d1.showPatients();
        d2.showPatients();
        p1.showConsultedDoctors();
        p2.showConsultedDoctors();
    }
}

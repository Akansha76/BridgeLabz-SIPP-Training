package StreamApi;

// Stream API Example 2: Hospital Doctor Availability

import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean availableWeekend;

    Doctor(String name, String specialty, boolean availableWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableWeekend = availableWeekend;
    }

    @Override
    public String toString() {
        return name + " - " + specialty + " (Weekend: " + availableWeekend + ")";
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Meena", "Cardiologist", true),
            new Doctor("Dr. Ravi", "Orthopedic", false),
            new Doctor("Dr. Anjali", "Neurologist", true),
            new Doctor("Dr. Vikram", "Dermatologist", true)
        );

        doctors.stream()
               .filter(d -> d.availableWeekend)
               .sorted(Comparator.comparing(d -> d.specialty))
               .forEach(System.out::println);
    }
}

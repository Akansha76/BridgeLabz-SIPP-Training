package EncaplsulationPolymorphismAbstraction;

import java.util.*;

// 1. Abstract Class: Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Encapsulated sensitive data
    private String diagnosis;
    private List<String> medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Encapsulated setters and access
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    protected void addToHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory);
    }

    // Concrete method
    public String getPatientDetails() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age;
    }

    // Abstract method
    public abstract double calculateBill();
}

// 2. Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// 3a. InPatient Class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(String id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        addToHistory("InPatient: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName());
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// 3b. OutPatient Class
class OutPatient extends Patient implements MedicalRecord {
    private int visits;
    private double consultationFee;

    public OutPatient(String id, String name, int age, int visits, double consultationFee) {
        super(id, name, age);
        this.visits = visits;
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return visits * consultationFee;
    }

    @Override
    public void addRecord(String record) {
        addToHistory("OutPatient: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName());
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// 4. Utility Class
class PatientManager {
    public static void printBills(List<Patient> patients) {
        System.out.println("Hospital Billing Summary");
        System.out.println("-------------------------------------------");
        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Diagnosis: " + p.getDiagnosis());
            System.out.println("Total Bill: Rs. " + p.calculateBill());
            System.out.println();
        }
    }
}

// 5. Main Class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();

        InPatient p1 = new InPatient("P101", "Rahul Sharma", 45, 5, 2000);
        p1.setDiagnosis("Pneumonia");
        p1.addRecord("Admitted to Ward A");
        p1.addRecord("Given antibiotics");

        OutPatient p2 = new OutPatient("P102", "Anita Gupta", 32, 3, 500);
        p2.setDiagnosis("Migraine");
        p2.addRecord("Consultation with Dr. Mehta");
        p2.addRecord("Prescribed pain relievers");

        patientList.add(p1);
        patientList.add(p2);

        // Display bills using polymorphism
        PatientManager.printBills(patientList);

        // View individual medical records
        System.out.println("Viewing Medical Records");

        p1.viewRecords();
        System.out.println();
        p2.viewRecords();
    }
}

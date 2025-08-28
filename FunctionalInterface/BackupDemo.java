package FunctionalInterface;

// File: BackupDemo.java

import java.io.*;

interface BackupMarker {}  // Custom marker interface

class Employee implements Serializable, BackupMarker {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + "}";
    }
}

public class BackupDemo {
    public static void main(String[] args) {
        Employee emp = new Employee("Akanksha", 101);

        // Check if eligible for backup
        if (emp instanceof BackupMarker) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
                oos.writeObject(emp);
                System.out.println("Backup Successful: " + emp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Object not eligible for backup!");
        }
    }
}

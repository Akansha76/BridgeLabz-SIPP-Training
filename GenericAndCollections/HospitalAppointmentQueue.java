import java.util.*;

class Appointment {
    private String patientName;
    private String doctorName;
    private String timeSlot;

    public Appointment(String patientName, String doctorName, String timeSlot) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }

    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getTimeSlot() { return timeSlot; }

    @Override
    public String toString() {
        return patientName + " - Dr. " + doctorName + " at " + timeSlot;
    }
}

class GenericQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public void add(T item) {
        queue.offer(item);
    }

    public T serve() {
        return queue.poll();
    }

    public T peek() {
        return queue.peek();
    }

    public void printQueue() {
        for (T item : queue) {
            System.out.println(item);
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class HospitalAppointmentQueue {
    public static void main(String[] args) {
        GenericQueue<Appointment> appointmentQueue = new GenericQueue<>();

        appointmentQueue.add(new Appointment("John Doe", "Smith", "10:00 AM"));
        appointmentQueue.add(new Appointment("Jane Roe", "Brown", "10:30 AM"));
        appointmentQueue.add(new Appointment("Mark Lee", "Adams", "11:00 AM"));

        System.out.println("All Appointments:");
        appointmentQueue.printQueue();

        System.out.println("\nNext Appointment: " + appointmentQueue.peek());

        System.out.println("\nServing Appointment: " + appointmentQueue.serve());

        System.out.println("\nRemaining Appointments:");
        appointmentQueue.printQueue();

        // Generic usage example for other types (e.g., Lab Tests)
        System.out.println("\n--- Lab Test Queue Example ---");
        GenericQueue<String> labTestQueue = new GenericQueue<>();
        labTestQueue.add("Blood Test - Patient A");
        labTestQueue.add("X-Ray - Patient B");

        while (!labTestQueue.isEmpty()) {
            System.out.println("Processing: " + labTestQueue.serve());
        }
    }
}

import java.util.*;

class Reservation {
    private String customerName;
    private int tableNumber;
    private String reservationTime;

    public Reservation(String customerName, int tableNumber, String reservationTime) {
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.reservationTime = reservationTime;
    }

    public int getTableNumber() { return tableNumber; }
    public String getReservationTime() { return reservationTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return tableNumber == that.tableNumber && reservationTime.equals(that.reservationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber, reservationTime);
    }

    @Override
    public String toString() {
        return customerName + " - Table " + tableNumber + " at " + reservationTime;
    }
}

class ReservationSystem {
    private Set<Reservation> reservations = new TreeSet<>(Comparator.comparing(Reservation::getReservationTime));

    public boolean addReservation(Reservation reservation) {
        return reservations.add(reservation); // false if duplicate (same table & time)
    }

    public void printReservations() {
        for (Reservation res : reservations) {
            System.out.println(res);
        }
    }
}

public class RestaurantReservationSystem {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();

        system.addReservation(new Reservation("Alice", 1, "7:00 PM"));
        system.addReservation(new Reservation("Bob", 2, "7:30 PM"));
        system.addReservation(new Reservation("Alice", 1, "7:00 PM")); // duplicate

        System.out.println("Upcoming Reservations:");
        system.printReservations();
    }
}

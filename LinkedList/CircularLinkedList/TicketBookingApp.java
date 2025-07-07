package LinkedList.CircularLinkedList;
import java.util.*;
public class TicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n====== Ticket Reservation Menu ======");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Search Ticket (by Customer or Movie)");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int id;
            String customer, movie, seat, time;

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    customer = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    seat = sc.nextLine();
                    System.out.print("Enter Booking Time (e.g. 6:00PM): ");
                    time = sc.nextLine();
                    system.addTicket(id, customer, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to Cancel: ");
                    id = sc.nextInt();
                    system.removeTicket(id);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer or Movie Name to Search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting Ticket System...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}


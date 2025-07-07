package LinkedList.CircularLinkedList;

import java.util.*;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    Ticket next; // For circular link

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }

    void display() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Customer: " + customerName);
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Time: " + bookingTime);
        System.out.println("-------------------------------");
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int count = 0;

    // 1. Add new ticket at end
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head; // circular
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        count++;
        System.out.println(" Ticket added successfully.");
    }

    // 2. Remove ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket curr = head;
        Ticket prev = tail;

        do {
            if (curr.ticketId == ticketId) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                    if (curr == tail) tail = prev;
                }
                count--;
                System.out.println(" Ticket with ID " + ticketId + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println(" Ticket ID not found.");
    }

    // 3. Display all current tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println(" No booked tickets.");
            return;
        }

        Ticket temp = head;
        System.out.println("\n Current Booked Tickets:");
        do {
            temp.display();
            temp = temp.next;
        } while (temp != head);
    }

    // 4. Search ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                temp.movieName.equalsIgnoreCase(keyword)) {
                temp.display();
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println(" No matching tickets for: " + keyword);
    }

    // 5. Count total tickets
    public void countTickets() {
        System.out.println(" Total Tickets Booked: " + count);
    }
}

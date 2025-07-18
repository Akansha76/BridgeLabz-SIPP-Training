package ScenerioBased;

import java.util.*;

// Attendee class with constructor overloading
class Attendee {
    String name;
    int age;
    String email;

    // Constructor without email
    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "Not Provided";
    }

    // Constructor with email
    public Attendee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

public class EventTicketSystem {
    public static void main(String[] args) {
        // Event → Queue of Attendees
        HashMap<String, Queue<Attendee>> eventMap = new HashMap<>();

        // Create queues
        Queue<Attendee> concertQueue = new LinkedList<>();
        concertQueue.add(new Attendee("Akanksha", 22));
        concertQueue.add(new Attendee("Rahul", 25, "rahul@mail.com"));
        concertQueue.add(new Attendee("Sara", 21));

        Queue<Attendee> playQueue = new LinkedList<>();
        playQueue.add(new Attendee("Ravi", 30, "ravi@mail.com"));
        playQueue.add(new Attendee("Priya", 28));

        // Map events
        eventMap.put("Rock Concert", concertQueue);
        eventMap.put("Drama Play", playQueue);

        // Show queues
        System.out.println(" Event Ticket Queues:");
        for (String event : eventMap.keySet()) {
            System.out.println("Event: " + event);
            int pos = 1;
            for (Attendee a : eventMap.get(event)) {
                System.out.println("  " + pos++ + ". " + a.name + " (" + a.age + ") - " + a.email);
            }
        }

        // Search for position in queue
        String searchName = "Sara";
        System.out.println("\nFinding position of " + searchName + " in Rock Concert:");
        int index = 1;
        for (Attendee a : eventMap.get("Rock Concert")) {
            if (a.name.equalsIgnoreCase(searchName)) {
                System.out.println(searchName + " is at position: " + index);
                break;
            }
            index++;
        }
    }
}

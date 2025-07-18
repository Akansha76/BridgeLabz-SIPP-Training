package ScenerioBased.Event;

public class EventHiveApp {
    public static void main(String[] args) {
        Admin admin = new Admin();

        // Admin adds events
        Event techTalk = new Event("TechTalk 2025", "Mumbai", "2025-08-01");
        Event aiSummit = new Event("AI Summit", "Bangalore", "2025-08-15");

        admin.addEvent(techTalk);
        admin.addEvent(aiSummit);

        System.out.println();
        admin.showAllEvents();

        System.out.println("\n--- Registration Begins ---");

        // User registers
        User user1 = new User("Akanksha", "akanksha@example.com");
        Ticket t1 = user1.register(techTalk);

        User user2 = new User("Rahul", "rahul@example.com");
        Ticket t2 = user2.register(aiSummit);

        System.out.println("\n--- Event Removal ---");
        admin.removeEvent("TechTalk 2025");
    }
}

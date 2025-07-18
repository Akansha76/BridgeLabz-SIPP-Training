package ScenerioBased.Event;

public class Ticket {
    private String userName;
    private String eventName;

    public Ticket(String userName, String eventName) {
        this.userName = userName;
        this.eventName = eventName;
        System.out.println("🎫 Ticket issued to " + userName + " for event: " + eventName);
    }
}

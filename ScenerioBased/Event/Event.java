package ScenerioBased.Event;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private String location;
    private String date;

    public Event(String eventName, String location, String date) {
        this.eventName = eventName;
        this.location = location;
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public Ticket registerUser(User user) {
        System.out.println(user.getName() + " registered for event: " + eventName);
        return new Ticket(user.getName(), eventName);
    }

    public void showEventDetails() {
        System.out.println("Event: " + eventName + " | Location: " + location + " | Date: " + date);
    }
}


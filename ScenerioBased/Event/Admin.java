package ScenerioBased.Event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Admin implements EventManager {
    private List<Event> eventList = new ArrayList<>();

    @Override
    public void addEvent(Event event) {
        eventList.add(event);
        System.out.println("Event added: " + event.getEventName());
    }

    @Override
    public void removeEvent(String eventName) {
        Iterator<Event> iterator = eventList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEventName().equals(eventName)) {
                iterator.remove();
                System.out.println("Event removed: " + eventName);
                return;
            }
        }
        System.out.println("Event not found: " + eventName);
    }

    public void showAllEvents() {
        for (Event e : eventList) {
            e.showEventDetails();
        }
    }
}


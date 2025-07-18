package ScenerioBased.Event;

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Ticket register(Event event) {
        return event.registerUser(this);
    }

    public String getName() {
        return name;
    }
}

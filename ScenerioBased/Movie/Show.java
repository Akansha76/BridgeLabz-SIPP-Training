package ScenerioBased.Movie;

import java.time.LocalTime;

public class Show {
    String title;
    LocalTime time;

    public Show(String title, String timeStr) {
        this.title = title;
        this.time = LocalTime.parse(timeStr); // Format: "HH:mm"
    }

    public String toString() {
        return title + " at " + time;
    }
}

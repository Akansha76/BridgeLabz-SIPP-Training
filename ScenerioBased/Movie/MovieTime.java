package ScenerioBased.Movie;

import java.util.ArrayList;

public class MovieTime {
    private ArrayList<Show> shows;

    public MovieTime() {
        shows = new ArrayList<>();
    }

    // Insert using Insertion Sort logic
    public void addShow(Show newShow) {
        shows.add(newShow); // Add at end temporarily
        int i = shows.size() - 2;

        // Shift shows with later time to the right
        while (i >= 0 && shows.get(i).time.isAfter(newShow.time)) {
            shows.set(i + 1, shows.get(i));
            i--;
        }

        shows.set(i + 1, newShow); // Insert at correct position
    }

    // Display all shows in order
    public void displaySchedule() {
        System.out.println("Upcoming Shows:");
        for (Show show : shows) {
            System.out.println("- " + show);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        MovieTime movieTime = new MovieTime();

        movieTime.addShow(new Show("Avengers", "14:30"));
        movieTime.addShow(new Show("Batman", "10:15"));
        movieTime.addShow(new Show("Spiderman", "12:00"));
        movieTime.addShow(new Show("Superman", "09:45"));
        movieTime.addShow(new Show("Ironman", "16:00"));

        movieTime.displaySchedule();
    }
}


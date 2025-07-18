package ScenerioBased;

import java.util.*;

// Abstract Task class
abstract class Task {
    protected String title;
    public Task(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public abstract void execute();  // Abstraction
}

// Subclasses of Task
class Meeting extends Task {
    public Meeting(String title) {
        super(title);
    }
    public void execute() {
        System.out.println(" Attending meeting: " + title);
    }
}

class Workout extends Task {
    public Workout(String title) {
        super(title);
    }
    public void execute() {
        System.out.println("Doing workout: " + title);
    }
}

class CodingSession extends Task {
    public CodingSession(String title) {
        super(title);
    }
    public void execute() {
        System.out.println(" Coding: " + title);
    }
}

public class DailyPlannerApp {
    public static void main(String[] args) {
        LinkedList<Task> taskList = new LinkedList<>();

        // Adding tasks
        taskList.add(new Meeting("Team Sync"));
        taskList.add(new Workout("Morning Yoga"));
        taskList.add(new CodingSession("Java OOP Practice"));

        // Execute all tasks
        System.out.println(" Executing Daily Tasks:");
        for (Task t : taskList) {
            t.execute();
        }

        // Search by keyword (Linear Search)
        String keyword = "Java";
        System.out.println("\nSearching for tasks with keyword: " + keyword);
        for (Task t : taskList) {
            if (t.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(" Found: " + t.getTitle());
            }
        }
    }
}

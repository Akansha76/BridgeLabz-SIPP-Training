package LinkedList.CircularLinkedList;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtBeginning(101, "Design", 2, "2025-07-10");
        scheduler.addAtEnd(102, "Code", 1, "2025-07-15");
        scheduler.addAtPosition(2, 103, "Test", 3, "2025-07-20");

        scheduler.displayAllTasks();
        System.out.println();

        scheduler.viewCurrentTask(); // Show 1st
        scheduler.viewCurrentTask(); // Show 2nd
        scheduler.viewCurrentTask(); // Show 3rd
        scheduler.viewCurrentTask(); // Back to 1st (circular)

        System.out.println("\nSearching by priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemoving Task ID 102:");
        scheduler.removeById(102);
        scheduler.displayAllTasks();
    }
}

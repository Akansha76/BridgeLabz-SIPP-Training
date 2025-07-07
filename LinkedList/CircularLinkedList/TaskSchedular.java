package LinkedList.CircularLinkedList;

import java.util.*;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    void printTask() {
        System.out.println("ID: " + taskId + ", Name: " + taskName +
                ", Priority: " + priority + ", Due: " + dueDate);
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
        System.out.println("Task added at beginning.");
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
        System.out.println("Task added at end.");
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        System.out.println("Task added at position " + pos + ".");
    }

    // Remove by Task ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("No task to remove.");
            return;
        }

        Task curr = head, prev = null;
        do {
            if (curr.taskId == id) {
                if (curr == head) {
                    if (head.next == head) {
                        head = null;
                    } else {
                        Task last = head;
                        while (last.next != head)
                            last = last.next;
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Task with ID " + id + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task with ID " + id + " not found.");
    }

    // View current task and move to next
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        if (current == null)
            current = head;

        System.out.println("Current Task:");
        current.printTask();
        current = current.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("All Tasks:");
        Task temp = head;
        do {
            temp.printTask();
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                temp.printTask();
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task with priority " + priority + " found.");
    }
}

package LinkedList.CircularLinkedList;

import java.util.*;

class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;

    Process next;

    Process(int id, int burstTime, int priority) {
        this.processId = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int totalWaitingTime = 0;
    private int totalTurnaroundTime = 0;
    private int processCount = 0;

    // Add a process at the end
    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        processCount++;
        System.out.println("Process added: ID=" + id + ", BT=" + burstTime + ", P=" + priority);
    }

    // Remove process by ID
    private void removeProcess(int id) {
        if (head == null) return;

        Process curr = head, prev = tail;

        do {
            if (curr.processId == id) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                    if (curr == tail) tail = prev;
                }
                processCount--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display all processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }

        Process temp = head;
        System.out.println("\nCurrent Process Queue:");
        do {
            System.out.println("ID: " + temp.processId + ", BT: " + temp.burstTime + ", Remaining: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Round Robin Execution
    public void execute(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process curr = head;
        int currentTime = 0;

        System.out.println("\n🔁 Starting Round Robin Execution:");
        while (processCount > 0) {
            if (curr.remainingTime > 0) {
                int executedTime = Math.min(timeQuantum, curr.remainingTime);
                currentTime += executedTime;
                curr.remainingTime -= executedTime;

                // If completed, remove and calculate turnaround/waiting time
                if (curr.remainingTime == 0) {
                    curr.turnaroundTime = currentTime;
                    curr.waitingTime = curr.turnaroundTime - curr.burstTime;
                    totalWaitingTime += curr.waitingTime;
                    totalTurnaroundTime += curr.turnaroundTime;

                    System.out.println("✅ Process ID " + curr.processId + " completed at time " + currentTime);
                    removeProcess(curr.processId);
                } else {
                    System.out.println("⏳ Process ID " + curr.processId + " executed for " + executedTime + " units. Remaining: " + curr.remainingTime);
                }

                displayProcesses();
            }

            curr = curr.next;
        }

        displayAverageTimes();
    }

    // Display average waiting and turnaround times
    public void displayAverageTimes() {
        int total = totalWaitingTime + totalTurnaroundTime;
        System.out.println("\n Scheduling Results:");
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / (total == 0 ? 1 : total / 2));
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / (total == 0 ? 1 : total / 2));
    }
}


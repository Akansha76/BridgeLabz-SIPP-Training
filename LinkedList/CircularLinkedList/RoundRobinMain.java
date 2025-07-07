package LinkedList.CircularLinkedList;
import java.util.*;
public class RoundRobinMain {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);
        int choice, id, bt, priority, tq;

        while (true) {
            System.out.println("\n== Round Robin Scheduler Menu ==");
            System.out.println("1. Add Process");
            System.out.println("2. Display Process Queue");
            System.out.println("3. Start Scheduling");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    bt = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    scheduler.addProcess(id, bt, priority);
                    break;

                case 2:
                    scheduler.displayProcesses();
                    break;

                case 3:
                    System.out.print("Enter Time Quantum: ");
                    tq = sc.nextInt();
                    scheduler.execute(tq);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

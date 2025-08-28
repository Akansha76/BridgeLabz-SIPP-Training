package FunctionalInterface;

public class BackgroundJobExecution {
    public static void main(String[] args) {
        // Runnable tasks
        Runnable task1 = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(" Task 1 completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                Thread.sleep(500);
                System.out.println(" Task 2 completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task3 = () -> {
            try {
                Thread.sleep(1500);
                System.out.println(" Task 3 completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Run asynchronously using threads
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();

        System.out.println(" All tasks started in background...");
    }
}


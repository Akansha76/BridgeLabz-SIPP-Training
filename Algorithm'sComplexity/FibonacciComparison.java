public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};

        for (int n : testCases) {
            System.out.println("\nFibonacci Number: " + n);

            if (n <= 30) { // Avoid long wait
                long start = System.currentTimeMillis();
                int resultRec = fibonacciRecursive(n);
                long end = System.currentTimeMillis();
                System.out.println("Recursive Result: " + resultRec + ", Time: " + (end - start) + " ms");
            } else {
                System.out.println("Recursive Result: Unfeasible");
            }

            long start = System.currentTimeMillis();
            int resultItr = fibonacciIterative(n);
            long end = System.currentTimeMillis();
            System.out.println("Iterative Result: " + resultItr + ", Time: " + (end - start) + " ms");
        }
    }
}

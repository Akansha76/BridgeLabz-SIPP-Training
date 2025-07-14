package StringBuilderBuffer;

public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;
        String word = "hello";

        // Using StringBuffer (thread-safe)
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append(word);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        // Using StringBuilder (faster, non-thread-safe)
        long startBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sbd.append(word);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // Output results
        System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000 + " ms");
    }
}

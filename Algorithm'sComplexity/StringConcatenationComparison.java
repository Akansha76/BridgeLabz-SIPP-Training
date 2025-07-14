//package Algorithm'sComplexity;

public class StringConcatenationComparison {

    public static void main(String[] args) {
        int[] counts = {1000, 10000, 1000000};

        for (int n : counts) {
            System.out.println("\nOperations Count: " + n);

            // String (Immutable)
            long start = System.currentTimeMillis();
            String s = "";
            for (int i = 0; i < n; i++) {
                s += "a";  // slow due to new object creation
            }
            long end = System.currentTimeMillis();
            System.out.println("String Time: " + (end - start) + " ms");

            // StringBuilder (Fast)
            start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            end = System.currentTimeMillis();
            System.out.println("StringBuilder Time: " + (end - start) + " ms");

            // StringBuffer (Thread-safe)
            start = System.currentTimeMillis();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sbf.append("a");
            }
            end = System.currentTimeMillis();
            System.out.println("StringBuffer Time: " + (end - start) + " ms");
        }
    }
}


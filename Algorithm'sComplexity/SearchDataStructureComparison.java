//package Algorithm'sComplexity;

import java.util.*;

public class SearchDataStructureComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);

            int[] arr = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int val = rand.nextInt(size * 10);
                arr[i] = val;
                hashSet.add(val);
                treeSet.add(val);
            }

            int target = arr[rand.nextInt(size)];

            // Array search
            long start = System.nanoTime();
            boolean found = false;
            for (int val : arr) {
                if (val == target) {
                    found = true;
                    break;
                }
            }
            long end = System.nanoTime();
            System.out.printf("Array Search: %.3f ms\n", (end - start) / 1e6);

            // HashSet search
            start = System.nanoTime();
            hashSet.contains(target);
            end = System.nanoTime();
            System.out.printf("HashSet Search: %.6f ms\n", (end - start) / 1e6);

            // TreeSet search
            start = System.nanoTime();
            treeSet.contains(target);
            end = System.nanoTime();
            System.out.printf("TreeSet Search: %.3f ms\n", (end - start) / 1e6);
        }
    }
}

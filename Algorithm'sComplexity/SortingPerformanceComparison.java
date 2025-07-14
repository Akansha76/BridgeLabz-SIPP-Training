//package Algorithm'sComplexity;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};  // dataset sizes
        Random rand = new Random();

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++) {
                original[i] = rand.nextInt(size * 10);
            }

            System.out.println("\nDataset size: " + size);

            // Bubble Sort (only for size <= 10000 to avoid long wait)
            if (size <= 10000) {
                int[] bubbleArr = Arrays.copyOf(original, size);
                long start = System.currentTimeMillis();
                bubbleSort(bubbleArr);
                long end = System.currentTimeMillis();
                System.out.println("Bubble Sort Time: " + (end - start) + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }

            // Merge Sort
            int[] mergeArr = Arrays.copyOf(original, size);
            long start = System.currentTimeMillis();
            Arrays.sort(mergeArr); // Java uses optimized MergeSort/TimSort
            long end = System.currentTimeMillis();
            System.out.println("Merge Sort Time: " + (end - start) + " ms");

            // Quick Sort (custom)
            int[] quickArr = Arrays.copyOf(original, size);
            start = System.currentTimeMillis();
            Arrays.sort(quickArr); // Also uses QuickSort for primitives
            end = System.currentTimeMillis();
            System.out.println("Quick Sort Time: " + (end - start) + " ms");
        }
    }
}

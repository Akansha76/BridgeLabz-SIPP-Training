//package Algorithm'sComplexity;

import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search (assumes array is sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};  // dataset sizes
        Random rand = new Random();

        for (int size : sizes) {
            int[] data = new int[size];

            // Fill array with random integers
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10);  // wide range to avoid duplicates
            }

            int target = data[rand.nextInt(size)];  // Pick a random element as target

            System.out.println("\nDataset size: " + size);

            // --- Linear Search Timing ---
            long start = System.nanoTime();
            linearSearch(data, target);
            long end = System.nanoTime();
            double linearTime = (end - start) / 1e6; // Convert to ms
            System.out.printf("Linear Search Time: %.3f ms\n", linearTime);

            // --- Binary Search Timing ---
            Arrays.sort(data); // Sorting first
            start = System.nanoTime();
            binarySearch(data, target);
            end = System.nanoTime();
            double binaryTime = (end - start) / 1e6; // Convert to ms
            System.out.printf("Binary Search Time (after sort): %.3f ms\n", binaryTime);
        }
    }
}


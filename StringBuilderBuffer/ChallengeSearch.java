package StringBuilderBuffer;

import java.util.Arrays;

public class ChallengeSearch {

    // Linear search: First missing positive integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Mark values out of range or <=0 as n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Use index as a marker
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val <= n) {
                nums[val - 1] = -Math.abs(nums[val - 1]);
            }
        }

        // First positive index is the missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary search for a target (after sorting)
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr); // Must sort before binary search
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int[] copyForBinary = arr.clone();

        int missing = firstMissingPositive(arr);
        System.out.println("First missing positive: " + missing);

        int target = 1;
        int index = binarySearch(copyForBinary, target);
        System.out.println("Index of target (" + target + "): " + index);
    }
}


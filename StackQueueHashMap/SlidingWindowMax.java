package StackQueueHashMap;
import java.util.*;

public class SlidingWindowMax {
    public static List<Integer> maxInWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of window
            if (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.poll();
            }

            // Remove smaller elements from the end
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i); // Add current element index

            if (i >= k - 1) {
                result.add(nums[dq.peek()]); // Max of current window
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Window Max: " + maxInWindow(nums, k));
    }
}


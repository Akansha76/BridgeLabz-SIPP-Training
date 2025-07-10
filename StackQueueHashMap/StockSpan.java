package StackQueueHashMap;

import java.util.*;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            // Pop smaller or equal prices
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, price[i] is greater than all to the left
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);
        System.out.println("Span: " + Arrays.toString(span));
    }
}

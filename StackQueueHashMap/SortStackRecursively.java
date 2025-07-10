package StackQueueHashMap;

import java.util.Stack;

public class SortStackRecursively {

    // Function to sort the entire stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();         // Step 1: Pop the top element
            sortStack(stack);              // Step 2: Sort the remaining stack
            sortedInsert(stack, top);      // Step 3: Insert the popped item in sorted order
        }
    }

        // Helper function to insert an element into a sorted stack
    public static void sortedInsert(Stack<Integer> stack, int element) {
        // Base case: Either stack is empty or element is greater than top
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();           // Remove top
        sortedInsert(stack, element);     // Recursive insert
        stack.push(temp);                 // Push back top
    }

    // Driver code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack:   " + stack);
    }
}


import java.util.Scanner;

public class PalindromeCheck {

    //  Logic 1: Compare characters from start and end using loop
    public static boolean isPalindromeLoop(String text) {
        int start = 0;
        int end = getLength(text) - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive palindrome check
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    //  Logic 3: Using char array and reversed char array
    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to reverse a string using charAt()
    public static char[] reverseString(String str) {
        int len = getLength(str);
        char[] reversed = new char[len];

        for (int i = 0; i < len; i++) {
            reversed[i] = str.charAt(len - 1 - i);
        }
        return reversed;
    }

    // Method to calculate string length without using .length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Display result
    public static void displayResult(boolean result, int logicNumber) {
        System.out.println("Logic " + logicNumber + ": " + (result ? "Palindrome" : "Not a Palindrome"));
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Logic 1
        boolean result1 = isPalindromeLoop(text);
        displayResult(result1, 1);

        // Logic 2
        boolean result2 = isPalindromeRecursive(text, 0, getLength(text) - 1);
        displayResult(result2, 2);

        // Logic 3
        boolean result3 = isPalindromeCharArray(text);
        displayResult(result3, 3);
    }
}


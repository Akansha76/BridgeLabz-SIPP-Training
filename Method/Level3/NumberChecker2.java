package Level3;

import java.util.Arrays;

import java.util.Arrays;

public class NumberChecker2 {

    // Method to count digits in a number
    public static int countDigits(int num) {
        return Integer.toString(num).length();
    }

    // Method to store digits of a number in an array
    public static int[] getDigitsArray(int num) {
        String numStr = Integer.toString(num);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // Method to reverse an array
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    // Method to check if a number is palindrome using digits
    public static boolean isPalindrome(int num) {
        int[] original = getDigitsArray(num);
        int[] reversed = reverseArray(original);
        return areArraysEqual(original, reversed);
    }

    // Method to check if number is a duck number (contains zero, but not starting with it)
    public static boolean isDuckNumber(int num) {
        String numStr = Integer.toString(num);
        return numStr.contains("0") && !numStr.startsWith("0");
    }

    // Main method to test all the utilities
    public static void main(String[] args) {
        int number = 12321;
        int number2 = 1203;

        System.out.println("Number: " + number);
        System.out.println("Digit Count: " + countDigits(number));

        int[] digits = getDigitsArray(number);
        System.out.println("Digits: " + Arrays.toString(digits));

        int[] reversed = reverseArray(digits);
        System.out.println("Reversed Digits: " + Arrays.toString(reversed));

        System.out.println("Are original and reversed equal? " + areArraysEqual(digits, reversed));
        System.out.println("Is Palindrome? " + isPalindrome(number));
        System.out.println("Is Duck Number? " + isDuckNumber(number));

        System.out.println("\nNumber: " + number2);
        System.out.println("Is Palindrome? " + isPalindrome(number2));
        System.out.println("Is Duck Number? " + isDuckNumber(number2));
    }
}

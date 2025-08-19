package Level3;
import java.util.Scanner;

public class AnagramChecker {

    // Method to check if two strings are anagrams
    public static boolean isAnagram(String text1, String text2) {
        // Step 1: Check length
        if (getLength(text1) != getLength(text2)) {
            return false;
        }

        // Step 2: Create and fill frequency arrays
        int[] freq1 = new int[256]; // ASCII size
        int[] freq2 = new int[256];

        for (int i = 0; ; i++) {
            try {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(i);
                freq1[c1]++;
                freq2[c2]++;
            } catch (Exception e) {
                break;
            }
        }

        // Step 3: Compare both frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    // Helper method to calculate string length without using length()
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

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        if (isAnagram(text1, text2)) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are NOT anagrams.");
        }
    }
}

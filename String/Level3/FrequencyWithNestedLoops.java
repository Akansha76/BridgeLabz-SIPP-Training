import java.util.Scanner;

public class FrequencyWithNestedLoops {

    // Method to find frequency using nested loops and store result in a 1D array
    public static String[] getCharacterFrequencies(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];

        // Outer loop to initialize frequency
        for (int i = 0; i < len; i++) {
            freq[i] = 1;

            // Skip already counted characters
            if (chars[i] == '0') continue;

            // Inner loop to count duplicates
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark as counted
                }
            }
        }

        // Count number of valid (non-'0') characters
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Create result array
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " => " + freq[i];
            }
        }

        return result;
    }

    // Display method
    public static void displayFrequencies(String[] data) {
        System.out.println("Character Frequencies:");
        for (String entry : data) {
            System.out.println(entry);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[] frequencies = getCharacterFrequencies(input);
        displayFrequencies(frequencies);
    }
}

import java.util.Scanner;

public class FirstNonRepeatingChar {

    // Method to find the first non-repeating character using frequency array
    public static char getFirstNonRepeatingChar(String str) {
        int[] freq = new int[256]; // ASCII size

        // Step 1: Count frequency
        for (int i = 0; ; i++) {
            try {
                char c = str.charAt(i);
                freq[c]++;
            } catch (Exception e) {
                break;
            }
        }

        // Step 2: Return first char with freq 1
        for (int i = 0; ; i++) {
            try {
                char c = str.charAt(i);
                if (freq[c] == 1) {
                    return c;
                }
            } catch (Exception e) {
                break;
            }
        }

        return '\0'; // null character if none found
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char result = getFirstNonRepeatingChar(input);

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
    }
}

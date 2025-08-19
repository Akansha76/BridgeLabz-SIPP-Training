import java.util.Scanner;

public class FrequencyUsingUniqueCharacters {

    // Method to find length without using length()
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

    // Method to find unique characters in the string using charAt()
    public static char[] getUniqueCharacters(String str) {
        int len = getLength(str);
        char[] unique = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char currentChar = str.charAt(i);
            boolean isDuplicate = false;

            // Check if currentChar is already recorded
            for (int j = 0; j < uniqueCount; j++) {
                if (unique[j] == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                unique[uniqueCount++] = currentChar;
            }
        }

        // Trim the array to actual unique count
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    // Method to find frequency of characters using unique characters
    public static String[][] getCharacterFrequencies(String str) {
        int[] freq = new int[256]; // For all ASCII characters

        // Count frequency using ASCII index
        for (int i = 0; ; i++) {
            try {
                char c = str.charAt(i);
                freq[c]++;
            } catch (Exception e) {
                break;
            }
        }

        // Get unique characters
        char[] uniqueChars = getUniqueCharacters(str);

        // Prepare result 2D array
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    // Display result in tabular format
    public static void displayFrequencies(String[][] data) {
        System.out.println("Char\tFrequency");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = getCharacterFrequencies(input);
        displayFrequencies(result);
    }
}

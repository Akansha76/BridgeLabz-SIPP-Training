import java.util.Scanner;

public class CharFrequencyUsingCharAt {

    // Method to find the frequency of characters using charAt()
    public static String[][] getCharacterFrequencies(String str) {
        int[] freq = new int[256]; // ASCII range

        // Step 1: Count frequencies
        for (int i = 0; ; i++) {
            try {
                char c = str.charAt(i);
                freq[c]++;
            } catch (Exception e) {
                break;
            }
        }

        // Step 2: Prepare result for only unique characters in input
        String[][] result = new String[str.length()][2]; // max possible unique
        boolean[] added = new boolean[256];
        int count = 0;

        for (int i = 0; ; i++) {
            try {
                char c = str.charAt(i);
                if (!added[c]) {
                    result[count][0] = String.valueOf(c);
                    result[count][1] = String.valueOf(freq[c]);
                    added[c] = true;
                    count++;
                }
            } catch (Exception e) {
                break;
            }
        }

        // Step 3: Trim unused space in result array
        String[][] finalResult = new String[count][2];
        for (int i = 0; i < count; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }

        return finalResult;
    }

    // Method to display the frequency table
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

        String[][] frequencies = getCharacterFrequencies(input);
        displayFrequencies(frequencies);
    }
}

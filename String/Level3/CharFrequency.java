import java.util.Scanner;

public class CharFrequency {

    
    public static char[] getUniqueCharacters(String str) {
        String unique = "";
        for (int i = 0; ; i++) {
            try {
                char currentChar = str.charAt(i);
                boolean isUnique = true;

                // Check if currentChar is already in 'unique' string
                for (int j = 0; ; j++) {
                    try {
                        if (unique.charAt(j) == currentChar) {
                            isUnique = false;
                            break;
                        }
                    } catch (Exception e) {
                        break;
                    }
                }

                if (isUnique) {
                    unique += currentChar;
                }
            } catch (Exception e) {
                break;
            }
        }

        // Convert unique string to character array
        char[] uniqueChars = new char[unique.length()];
        for (int i = 0; i < unique.length(); i++) {
            uniqueChars[i] = unique.charAt(i);
        }

        return uniqueChars;
    }

    
    public static String[][] getCharacterFrequencies(String str) {
        int[] frequency = new int[256]; // ASCII characters range

        
        for (int i = 0; ; i++) {
            try {
                char c = str.charAt(i);
                frequency[c]++;
            } catch (Exception e) {
                break;
            }
        }

        // Get unique characters
        char[] uniqueChars = getUniqueCharacters(str);

        
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }

        return result;
    }

    // Method to display the 2D result array in tabular format
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



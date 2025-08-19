import java.util.Scanner;

public class CaseConversionDemo {

    // Method to manually convert text to uppercase
    public static String toUpperCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char) (ch - 32));  // Convert to uppercase
            } else {
                result.append(ch);  // Keep as is
            }
        }
        return result.toString();
    }

    // Method to manually convert text to lowercase
    public static String toLowerCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) (ch + 32));  // Convert to lowercase
            } else {
                result.append(ch);  // Keep as is
            }
        }
        return result.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        // Uppercase conversion and comparison
        String upperManual = toUpperCaseManual(input);
        String upperBuiltIn = input.toUpperCase();
        boolean isUpperEqual = compareStrings(upperManual, upperBuiltIn);

        System.out.println("\n--- Uppercase Conversion ---");
        System.out.println("Manual:   " + upperManual);
        System.out.println("Built-in: " + upperBuiltIn);
        System.out.println("Are equal: " + isUpperEqual);

        // Lowercase conversion and comparison
        String lowerManual = toLowerCaseManual(input);
        String lowerBuiltIn = input.toLowerCase();
        boolean isLowerEqual = compareStrings(lowerManual, lowerBuiltIn);

        System.out.println("\n--- Lowercase Conversion ---");
        System.out.println("Manual:   " + lowerManual);
        System.out.println("Built-in: " + lowerBuiltIn);
        System.out.println("Are equal: " + isLowerEqual);
    }
}

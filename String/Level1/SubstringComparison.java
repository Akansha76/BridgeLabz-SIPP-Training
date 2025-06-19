import java.util.Scanner;

public class SubstringComparison {

    // Method to create substring using charAt()
    public static String substringWithCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < text.length(); i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareWithCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the string: ");
        String text = scanner.next();

        
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        // Generate substrings
        String manualSubstring = substringWithCharAt(text, start, end);
        String builtinSubstring = text.substring(start, Math.min(end, text.length()));

        boolean areEqual = compareWithCharAt(manualSubstring, builtinSubstring);

        
        System.out.println("\nManual substring using charAt(): " + manualSubstring);
        System.out.println("Built-in substring(): " + builtinSubstring);
        System.out.println("Are both substrings equal? " + areEqual);

        scanner.close();
    }
}


import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate IllegalArgumentException without handling
    public static void generateIllegalArgument(String text) {
        System.out.println("\nGenerating IllegalArgumentException...");

        // This will throw an IllegalArgumentException
        String sub = text.substring(5, 3);  // Invalid: start > end
        System.out.println("Substring: " + sub);
    }

    // Method to handle IllegalArgumentException with try-catch
    public static void handleIllegalArgument(String text) {
        System.out.println("\nHandling IllegalArgumentException safely...");

        try {
            String sub = text.substring(5, 3);  // Invalid: start > end
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Step 1: Uncomment below to see the crash
        // generateIllegalArgument(input);

        // Step 2: Properly handled
        handleIllegalArgument(input);
    }
}

import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException without handling
    public static void generateNumberFormatException(String text) {
        System.out.println("\nGenerating NumberFormatException...");
        
        // This will throw NumberFormatException if text is not a valid integer
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }

    // Method to handle NumberFormatException using try-catch
    public static void handleNumberFormatException(String text) {
        System.out.println("\nHandling NumberFormatException safely...");
        
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a number (as text): ");
        String input = sc.nextLine();

        // Step 1: Uncomment this line to generate the unhandled exception
        // generateNumberFormatException(input);

        // Step 2: Properly handled version
        handleNumberFormatException(input);
    }
}

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate the exception (no try-catch)
    public static void generateStringIndexOutOfBounds(String text) {
        System.out.println("\nGenerating StringIndexOutOfBoundsException...");
        // Try to access a character beyond the length
        char ch = text.charAt(text.length()); // This will throw exception
        System.out.println("Character at invalid index: " + ch);
    }

    // Method to handle the exception using try-catch
    public static void handleStringIndexOutOfBounds(String text) {
        System.out.println("\nHandling StringIndexOutOfBoundsException safely...");

        try {
            // Accessing out-of-bounds index
            char ch = text.charAt(text.length()); // This will throw exception
            System.out.println("Character at invalid index: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();

        // Step 1: Uncomment below line to generate the exception (crashes the program)
        // generateStringIndexOutOfBounds(userInput);

        // Step 2: Handle the exception safely
        handleStringIndexOutOfBounds(userInput);
    }
}


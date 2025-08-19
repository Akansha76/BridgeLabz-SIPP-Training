import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate ArrayIndexOutOfBoundsException (without handling)
    public static void generateArrayIndexOutOfBounds(String[] names) {
        System.out.println("\nGenerating ArrayIndexOutOfBoundsException...");

        // This will throw ArrayIndexOutOfBoundsException if index >= names.length
        System.out.println("Accessing index 10: " + names[10]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleArrayIndexOutOfBounds(String[] names) {
        System.out.println("\nHandling ArrayIndexOutOfBoundsException safely...");

        try {
            System.out.println("Accessing index 10: " + names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating array of names
        String[] names = new String[5];
        System.out.println("Enter 5 names:");
        for (int i = 0; i < names.length; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        // Step 1: Uncomment below to see the unhandled exception
        // generateArrayIndexOutOfBounds(names);

        // Step 2: Handled version
        handleArrayIndexOutOfBounds(names);
    }
}

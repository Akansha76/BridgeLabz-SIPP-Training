public class NullPointerDemo {

    // Method to generate NullPointerException (without try-catch)
    public static void generateNullPointer() {
        String text = null;
        System.out.println("Generating NullPointerException...");
        // This will throw NullPointerException
        System.out.println("Length of text: " + text.length());
    }

    // Method to handle NullPointerException using try-catch
    public static void handleNullPointer() {
        String text = null;
        System.out.println("\nHandling NullPointerException safely...");

        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Step 1: Call method that generates the exception (will crash if uncommented)
        // generateNullPointer(); // Uncomment to see the exception crash

        // Step 2: Call method that handles the exception safely
        handleNullPointer();
    }
}

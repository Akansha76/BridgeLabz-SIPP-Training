import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter first number:");
        float number1 = sc.nextFloat();
        System.out.println("Enter second number:");
        float number2 = sc.nextFloat();
        System.out.println("Addition: " + (number1 + number2));
        System.out.println("Subtraction: " + (number1 - number2));
        System.out.println("Multiplication: " + (number1 * number2));
        if (number2 != 0) {
            System.out.println("Division: " + (number1 / number2));
        } else {
            System.out.println("Division: Cannot divide by zero");
        }
    }    
    
}

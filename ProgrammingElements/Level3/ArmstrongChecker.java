package Level3;

public class ArmstrongChecker {
    
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();
        
        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }
}

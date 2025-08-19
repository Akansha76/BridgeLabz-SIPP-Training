// Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
// Hint => 
// Method to Check if a number is a perfect number. Perfect numbers are positive integers that are equal to the sum of their proper divisors
// Method to find the number is an abundant number. A number is called an abundant number if the sum of its proper divisors is greater than the number itself
// Method to find the number is a deficient number. A number is called a deficient number if the sum of its proper divisors is less than the number itself
// Method to Check if a number is a strong number. A number is called a strong number if the sum of the factorial of its digits is equal to the number itself

package Level3;

import java.util.Scanner;

public class NumberCheck1 {
    private NumberCheck1() {
       Scanner sc=new Scanner(System.in);
         System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Is Perfect Number: " + isPerfect(num));
        System.out.println("Is Abundant Number: " + isAbundant(num));
        System.out.println("Is Deficient Number: " + isDeficient(num));
        System.out.println("Is Strong Number: " + isStrong(num));
    }
    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
    public static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum > num;
    }
    public static boolean isDeficient(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum < num;
    }
    public static boolean isStrong(int num) {
        int sum = 0;
        int originalNum = num;
        while (num > 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }
        return sum == originalNum;
    }
    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

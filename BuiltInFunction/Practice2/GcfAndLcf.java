package Practice2;
import java.util.Scanner;
public class GcfAndLcf {
    
public static void gcdLcmCalculator(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int gcd = computeGCD(a, b);
        int lcm = computeLCM(a, b);

        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    public static int computeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int computeLCM(int a, int b) {
        return (a * b) / computeGCD(a, b);
    }
}    
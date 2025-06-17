package Level1;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double principal =sc.nextDouble() ; // Principal amount
        double rate = sc.nextDouble(); // Rate of interest per annum
        int time = sc.nextInt(); // Time in years

        // Calculate simple interest
        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        // Output the result
        System.out.println("The Simple Interest is: " + simpleInterest);
    }
    public static double calculateSimpleInterest(double principal, double rate, int time) {
        return (principal * rate * time) / 100;
    }    
}

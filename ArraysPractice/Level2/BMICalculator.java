package Level2;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of persons
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();

        // Step 2: Define arrays
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Step 3: Take input for height and weight
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Enter weight (in kg): ");
            weight[i] = sc.nextDouble();
            System.out.print("Enter height (in meters): ");
            height[i] = sc.nextDouble();

            if (weight[i] <= 0 || height[i] <= 0) {
                System.out.println("Invalid input! Enter positive values.");
                i--; // re-enter for this person
            }
        }

        // Step 4: Calculate BMI and determine status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25.0) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 30.0) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Step 5: Display details
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", height[i], weight[i], bmi[i], status[i]);
        }
    }
}

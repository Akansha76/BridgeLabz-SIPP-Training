import java.util.Scanner;

public class BMICalculator {

    public static String[][] computeBMI(double[][] hwData) {
        String[][] result = new String[10][4]; // height, weight, BMI, status

        for (int i = 0; i < 10; i++) {
            double weight = hwData[i][0];
            double heightInMeters = hwData[i][1] / 100.0;
            double bmi = weight / (heightInMeters * heightInMeters);
            String status = getStatus(bmi);

            result[i][0] = String.format("%.1f", hwData[i][1]); // height in cm
            result[i][1] = String.format("%.1f", weight);       // weight in kg
            result[i][2] = String.format("%.1f", bmi);          // BMI
            result[i][3] = status;                              // Status
        }

        return result;
    }

    
    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

  
    public static void displayResult(String[][] data) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwData = new double[10][2]; // [][0] = weight, [][1] = height

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            hwData[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            hwData[i][1] = sc.nextDouble();
        }

        String[][] result = computeBMI(hwData);
        displayResult(result);
    }
}



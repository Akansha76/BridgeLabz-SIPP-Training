package Level2;
import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        System.out.println("Enter details for 10 employees:");

        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter salary: ");
            double s = sc.nextDouble();
            System.out.print("Enter years of service: ");
            double y = sc.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input! Please enter again.");
                i--; // decrement to re-enter data for this employee
                continue;
            }

            salary[i] = s;
            yearsOfService[i] = y;
        }

        // Calculating bonus and new salary
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Output
        System.out.println("\n--- Summary ---");
        System.out.printf("Total Old Salary:\n", totalOldSalary);
        System.out.printf("Total Bonus Paid:\n", totalBonus);
        System.out.printf("Total New Salary:\n", totalNewSalary);
    }
}

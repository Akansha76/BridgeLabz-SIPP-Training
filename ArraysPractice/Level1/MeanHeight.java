package Level1;
import java.util.Scanner;

public class MeanHeight{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] nums = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            if (index == 10) break;

            System.out.print("Enter number (stop at 0 or negative): ");
            double value = sc.nextDouble();
            if (value <= 0) break;

            nums[index] = value;
            index++;
        }

        for (int i = 0; i < index; i++) {
            System.out.println("Value: " + nums[i]);
            total += nums[i];
        }

        System.out.println("Total Sum: " + total);
    }
}

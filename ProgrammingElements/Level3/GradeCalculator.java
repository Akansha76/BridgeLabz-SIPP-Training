package Level3;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Physics Marks: ");
        int phy = sc.nextInt();
        System.out.print("Chemistry Marks: ");
        int chem = sc.nextInt();
        System.out.print("Maths Marks: ");
        int math = sc.nextInt();

        double avg = (phy + chem + math) / 3.0;
        System.out.println("Average Marks: " + avg);

        if (avg >= 90) {
            System.out.println("Grade: A+ | Excellent");
        } else if (avg >= 80) {
            System.out.println("Grade: A | Very Good");
        } else if (avg >= 70) {
            System.out.println("Grade: B | Good");
        } else if (avg >= 60) {
            System.out.println("Grade: C | Fair");
        } else {
            System.out.println("Grade: F | Fail");
        }
    }
}

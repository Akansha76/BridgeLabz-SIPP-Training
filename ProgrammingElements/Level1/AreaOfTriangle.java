import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter base (in inches):");
        double base = sc.nextDouble();
        System.out.println("Enter height (in inches):");
        double height = sc.nextDouble();
        double areaInInches = 0.5 * base * height;
        double areaInCm = areaInInches * 6.4516; // 1 sq inch = 6.4516 sq cm
        System.out.printf("Area in square inches: %.2f, Area in square centimeters: %.2f\n", areaInInches, areaInCm);

    }
}

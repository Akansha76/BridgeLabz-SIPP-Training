import java.util.Scanner;

public class DistanceInYardAndMile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter distance in feet:");
        double distanceInFeet = sc.nextDouble();
        double yards = distanceInFeet / 3;
        double miles = yards / 1760;
        System.out.printf("The distance is %.2f feet, %.2f yards, and %.5f miles\n", distanceInFeet, yards, miles);

    }    

}

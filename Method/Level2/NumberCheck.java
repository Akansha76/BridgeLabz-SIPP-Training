package Level2;

import java.util.Scanner;

public class NumberCheck {

    public static boolean isPositive(int num) { return num >= 0; }

    public static boolean isEven(int num) { return num % 2 == 0; }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();
            if (isPositive(arr[i])) {
                System.out.println(isEven(arr[i]) ? "Positive and Even" : "Positive and Odd");
            } else {
                System.out.println("Negative");
            }
        }

        int result = compare(arr[0], arr[4]);
        if (result == 1) System.out.println("First > Last");
        else if (result == 0) System.out.println("First = Last");
        else System.out.println("First < Last");
    }
}

package Level1;
import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = sc.nextInt();
        }

        for (int num : nums) {
            if (num > 0) {
                if (num % 2 == 0) System.out.println(num + " is Positive and Even");
                else System.out.println(num + " is Positive and Odd");
            } else if (num < 0) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (nums[0] == nums[4]) System.out.println("First and Last elements are Equal");
        else if (nums[0] > nums[4]) System.out.println("First element is Greater than Last");
        else System.out.println("First element is Less than Last");
    }
}

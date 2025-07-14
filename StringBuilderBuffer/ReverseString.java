package StringBuilderBuffer;

import java.util.Scanner;

public class ReverseString {
    public static String reverse(String input) {
        
        StringBuilder sb = new StringBuilder(input);
        
       
        sb.reverse();
        
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        String reversed = reverse(input);
        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}


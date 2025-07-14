package StringBuilderBuffer;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
    
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        
        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);             
                result.append(ch);        
            }
        }

        return result.toString();         
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

       
        String uniqueString = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + uniqueString);

        scanner.close();
    }
}

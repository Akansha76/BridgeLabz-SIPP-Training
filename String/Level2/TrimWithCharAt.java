package Level2;
import java.util.*;
public class TrimWithCharAt {

    public static int[] findTrimIndexes(String s) {
        int start = 0, end = 0;
        try {
            while (s.charAt(start) == ' ') start++;
            end = start;
            while (true) {
                s.charAt(end++);
            }
        } catch (Exception e) {
            end--;
            while (s.charAt(end) == ' ') end--;
        }
        return new int[]{start, end};
    }

    public static String customSubstring(String s, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        int[] indexes = findTrimIndexes(input);
        String trimmedCustom = customSubstring(input, indexes[0], indexes[1]);
        String trimmedBuiltIn = input.trim();

        System.out.println("Trimmed (Custom): [" + trimmedCustom + "]");
        System.out.println("Trimmed (Built-in): [" + trimmedBuiltIn + "]");
        System.out.println("Match? " + trimmedCustom.equals(trimmedBuiltIn));
    }
}

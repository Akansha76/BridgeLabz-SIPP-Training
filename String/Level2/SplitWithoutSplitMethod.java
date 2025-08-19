package Level2;
import java.util.*;
public class SplitWithoutSplitMethod {

    public static String[] splitWords(String str) {
        int wordCount = 1;
        for (int i = 0;; i++) {
            try {
                if (str.charAt(i) == ' ') wordCount++;
            } catch (Exception e) {
                break;
            }
        }

        String[] words = new String[wordCount];
        int start = 0, index = 0;

        for (int i = 0;; i++) {
            try {
                if (str.charAt(i) == ' ') {
                    words[index++] = str.substring(start, i);
                    start = i + 1;
                }
            } catch (Exception e) {
                words[index] = str.substring(start);
                break;
            }
        }

        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] customSplit = splitWords(input);
        String[] builtInSplit = input.split(" ");

        System.out.println("Custom Split: " + Arrays.toString(customSplit));
        System.out.println("Built-in Split: " + Arrays.toString(builtInSplit));

        System.out.println("Are both equal? " + compareArrays(customSplit, builtInSplit));
    }
}

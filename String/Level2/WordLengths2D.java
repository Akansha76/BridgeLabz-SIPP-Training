package Level2;
import java.util.*;
public class WordLengths2D {

    public static int getLength(String word) {
        int len = 0;
        try {
            while (true) {
                word.charAt(len++);
            }
        } catch (Exception e) {
            return len;
        }
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String input = sc.nextLine();

        String[] words = input.split(" ");
        String[][] result = getWordsWithLengths(words);

        System.out.println("Word\tLength");
        for (String[] row : result) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
    }
}


package Level2;
import java.util.*;
public class ShortestLongestWord {

    public static String getShortest(String[][] wordLengths) {
        String shortest = wordLengths[0][0];
        int min = Integer.parseInt(wordLengths[0][1]);
        for (String[] row : wordLengths) {
            int len = Integer.parseInt(row[1]);
            if (len < min) {
                shortest = row[0];
                min = len;
            }
        }
        return shortest;
    }

    public static String getLongest(String[][] wordLengths) {
        String longest = wordLengths[0][0];
        int max = Integer.parseInt(wordLengths[0][1]);
        for (String[] row : wordLengths) {
            int len = Integer.parseInt(row[1]);
            if (len > max) {
                longest = row[0];
                max = len;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String input = sc.nextLine();

        String[] words = input.split(" ");
        String[][] wordLengths = WordLengths2D.getWordsWithLengths(words);

        System.out.println("Shortest word: " + getShortest(wordLengths));
        System.out.println("Longest word: " + getLongest(wordLengths));
    }
}

package Level2;
import java.util.*;
public class VowelConsonantCounter {

   public static boolean isVowel(char c) {
    c = Character.toLowerCase(c);
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
}


    public static int[] countVowelsAndConsonants(String input) {
        int vowels = 0, consonants = 0;
        for (int i = 0;; i++) {
            try {
                char c = input.charAt(i);
                if (Character.isLetter(c)) {
                    if (isVowel(c)) vowels++;
                    else consonants++;
                }
            } catch (Exception e) {
                break;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        int[] count = countVowelsAndConsonants(input);
        System.out.println("Vowels: " + count[0]);
        System.out.println("Consonants: " + count[1]);
    }
}

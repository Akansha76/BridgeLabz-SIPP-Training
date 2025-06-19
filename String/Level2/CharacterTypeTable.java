package Level2;
import java.util.Scanner;
public class CharacterTypeTable {

    public static String getCharType(char c) {
        c = Character.toLowerCase(c);
       if (Character.isLetter(c)) {
       if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
          return "Vowel";
       } else {
          return "Consonant";
       }
    }else {
        return "Not a Letter";
       }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        System.out.println("Char\tType");
        for (int i = 0;; i++) {
            try {
                char c = input.charAt(i);
                System.out.println(c + "\t" + getCharType(c));
            } catch (Exception e) {
                break;
            }
        }
    }
}

import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123", "123456"};

        String regex = "^#[A-Fa-f0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);

        for (String color : colors) {
            System.out.println(color + " → " + (pattern.matcher(color).matches() ? "Valid" : "Invalid"));
        }
    }
}

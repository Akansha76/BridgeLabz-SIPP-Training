import java.util.regex.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345", "XY9876"};

        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        for (String plate : plates) {
            System.out.println(plate + " → " + (pattern.matcher(plate).matches() ? "Valid" : "Invalid"));
        }
    }
}

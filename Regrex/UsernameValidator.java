import java.util.regex.*;

public class UsernameValidator{
    public static void main(String[] args) {
        String[] testUsernames = {"user_123", "123user", "us", "Valid_Name12"};

        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";  // must start with letter, 5–15 length
        Pattern pattern = Pattern.compile(regex);

        for (String username : testUsernames) {
            Matcher matcher = pattern.matcher(username);
            System.out.println(username + " → " + (matcher.matches() ? "Valid" : "Invalid"));
        }
    }
}

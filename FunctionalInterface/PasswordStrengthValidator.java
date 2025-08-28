package FunctionalInterface;

interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&     // at least 1 uppercase
               password.matches(".*[a-z].*") &&     // at least 1 lowercase
               password.matches(".*\\d.*") &&       // at least 1 digit
               password.matches(".*[@#$%^&+=!].*"); // at least 1 special char
    }
}

public class PasswordStrengthValidator {
    public static void main(String[] args) {
        String[] passwords = {"hello123", "Strong@123", "WeakPass", "MySecure#2025"};

        for (String pwd : passwords) {
            if (SecurityUtils.isStrongPassword(pwd)) {
                System.out.println(" Strong password: " + pwd);
            } else {
                System.out.println(" Weak password: " + pwd);
            }
        }
    }
}

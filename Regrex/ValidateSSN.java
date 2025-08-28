public class ValidateSSN {
    public static void main(String[] args) {
        String ssn1 = "123-45-6789";
        String ssn2 = "123456789";

        String regex = "^(?!000|666)[0-9]{3}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";

        System.out.println(ssn1.matches(regex) ? "Valid SSN: " + ssn1 : "Invalid SSN");
        System.out.println(ssn2.matches(regex) ? "Valid SSN: " + ssn2 : "Invalid SSN");
    }
}

package FunctionalInterface;

import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        int charLimit = 20;

        // Function to calculate string length
        Function<String, Integer> lengthFunction = str -> str.length();

        String[] messages = {
            "Hello World",
            "This message is too long to send!",
            "Java is fun"
        };

        for (String msg : messages) {
            int length = lengthFunction.apply(msg);
            if (length > charLimit) {
                System.out.println(" Message exceeds limit (" + length + " chars): " + msg);
            } else {
                System.out.println(" Message OK (" + length + " chars): " + msg);
            }
        }
    }
}

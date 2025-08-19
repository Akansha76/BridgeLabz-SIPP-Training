package Level3;

import java.util.*;

public class OTPGenerator {
    public static String generateOTP() {
        StringBuilder otp = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            otp.append(rand.nextInt(10));
        }
        return otp.toString();
    }

    public static boolean checkUnique(String[] otps) {
        Set<String> unique = new HashSet<>(Arrays.asList(otps));
        return unique.size() == otps.length;
    }

    public static void main(String[] args) {
        String[] otps = new String[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        System.out.println("Are all OTPs unique? " + checkUnique(otps));
    }
}


package Level1;

import java.util.Scanner;

public class HandShake {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int n = 5; // Example number of people
        int handshakes = calculateHandshakes(n);
        System.out.println("Total handshakes: " + handshakes);
    }
    public static int calculateHandshakes(int n) {
       
        return (n * (n - 1)) / 2;
    }
}

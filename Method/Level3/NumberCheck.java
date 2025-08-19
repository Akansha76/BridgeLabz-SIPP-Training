package Level3;

import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean prime= prime(n);
        boolean neon= neon(n);
        boolean spy= spy(n);
        boolean automorphic= automorphic(n);
        System.out.println("Is Prime: " + prime);
        System.out.println("Is Neon: " + neon);
        System.out.println("Is Spy: " + spy);
        System.out.println("Is Automorphic: " + automorphic);
        System.out.println("Is Buzz: " + buzz(n));
    }
    public static boolean prime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static boolean neon(int n){
        int sum = 0;
        int square = n * n;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == n;
    }
    public static boolean spy(int n){
        int sum = 0, product = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return sum == product;
    }
    public static boolean automorphic(int n){
        int square = n * n;
        String strN = String.valueOf(n);
        String strSquare = String.valueOf(square);
        return strSquare.endsWith(strN);
    }
    public static boolean buzz(int n){
        return n % 7 == 0 || String.valueOf(n).contains("7");
    }

}

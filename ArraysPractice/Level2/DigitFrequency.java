package Level2;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        String s=String.valueOf(num);
        int[] feq=new int[10];
        int[] arr=new int[s.length()];
        int c=s.length();
        for(int i=0;i<c;i++){
            arr[i]=s.charAt(i)-'0';
        }
        for (int i = 0; i < arr.length; i++) {
            feq[arr[i]]++;
        } 
        

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (feq[i] > 0) {
                System.out.println("Digit " + i + " => " + feq[i] + " time");
            }
        }
    }
}

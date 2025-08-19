package Level2;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class ReverseNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int rev=0;
        String s=String.valueOf(num);
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int rem=num%10;
            // rev=rev*10+rem;
            arr[i]=rem;
            num=num/10;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);

        }
        
    }
}

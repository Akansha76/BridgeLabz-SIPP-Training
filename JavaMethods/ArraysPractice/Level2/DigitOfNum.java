package Level2;

import java.util.Scanner;

public class DigitOfNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] digit =new int[10];
        int idx=0;
        while(num!=0){

            int rem=num%10;
            digit[idx++]=rem;
            num=num/10;
            if(idx==10){
                break;
            }



        }
        int largest=0,sec_largest=0;
        while(idx>0){
            idx--;
            if(digit[idx]>largest){
                sec_largest=largest;
                largest=digit[idx];
            }else if(digit[idx]>sec_largest && digit[idx]!=largest){
                sec_largest=digit[idx];
            }

        }
        System.out.println("Largest num:"+largest);
        System.out.println("Second Largest num:"+sec_largest);

    }
}

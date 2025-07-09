//package Review;
import java.util.*;
public class count {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string to count no. of vowels and const :");
        String s=sc.next();
        int no_of_vowels=0;
        int no_of_cont=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                no_of_vowels++;
            }else{
                no_of_cont++;
            }

        }
        System.out.println("Num of vowels "+no_of_vowels);
        System.out.println("Num of cont "+no_of_cont);
    }
}

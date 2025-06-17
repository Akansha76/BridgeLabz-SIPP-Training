import java.util.*;
public class CheckNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String result = checkNumber(num);
        System.out.println(result);
    }
    public static String checkNumber(int n){
        if(n>0){
            return "Positive Number";
        } else if(n<0){
            return "Negative Number";
        } else {
            return "Zero";
        }
    }
}

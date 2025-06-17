import java.security.Principal;
import java.sql.Time;
import java.util.Scanner;

class SimpleInterest{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double principal = sc.nextDouble();
        double rate =sc.nextDouble(); 
        int time = sc.nextInt();

        
        double ans = interest(principal,rate,time);

       
        System.out.println("The Simple Interest is "+ans+" for Principal "+principal+" Rate of Interest "+rate+" and Time "+time);
    }
    public static double interest(double p,double r,int t){
        return (p*r*t)/100;
    }
}
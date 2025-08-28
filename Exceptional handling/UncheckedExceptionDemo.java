import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       

        try{
            System.out.println("enter numerator:");
            int n1=sc.nextInt();
            System.out.println("enter denominator:");
            int n2=sc.nextInt();
            System.out.println(n1/n2);

        }catch(InputMismatchException e){
            System.out.println("Error: Please enter valid numeric values.");
        }
        catch(ArithmeticException e){
            System.out.println("Error: Division by zero is not allowed.");

        }
    }
}

import java.util.Scanner;

//custom Exception
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class CustomExeption {
    
    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be 18 or abive");
        }else{
            System.out.println("Access granted");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter valid age:");
            int age=sc.nextInt();
            validateAge(age);
            
        }catch(InvalidAgeException e){
            System.out.println("Enter the valid age");

        }
    }
}

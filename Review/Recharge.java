package Review;
import java.util.Scanner;

public class Recharge {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int Balance=5000;
        
        int AnotherRecharge=1;
        while (AnotherRecharge>=1 && Balance>=299) {
            System.out.println("Available Balance is Rs."+Balance);
            System.out.println("Available Recharge Plans Are:");
            System.out.println("Enter 1 for Jio 1GB/day for 28 days at Rs. 239");
            System.out.println("Enter 2 for Airtel 1.5GB/day for 28 days at Rs. 299");
            System.out.println("Enter 3 for Vi 2GB/day for 28 days at Rs. 399");
            System.out.println("Enter 4 for BSNL 2GB/day for 28 days at Rs. 499");
            
            
        
            switch (sc.next()) {
                case "1":
                    System.out.println("Jio 1GB/day for 28 days at Rs. 239 is SUCCESSFULLY RECHARGED");
                    Balance -= 239; // Deduct the recharge amount from balance
                    AnotherRecharge-=1;
                    System.out.println("Your remaining balance is Rs. " + Balance);
                
                    break;
                case "2":
                   System.out.println("Airtel 1.5GB/day for 28 days at Rs. 299 is SUCCESSFULLY RECHARGED");
                    Balance -= 299; 
                    AnotherRecharge-=1;
                    System.out.println("Your remaining balance is Rs. " + Balance);
                
                   break;
                case "3":
                   System.out.println("Vi 2GB/day for 28 days at Rs. 299 is SUCCESSFULLY RECHARGED");
                    Balance -= 299; 
                    AnotherRecharge-=1;
                    System.out.println("Your remaining balance is Rs. " + Balance);
                  break;
                case "4":
                   System.out.println("BSNL 2GB/day for 28 days at Rs. 291 is SUCCESSFULLY RECHARGED");
                    Balance -= 291;
                    AnotherRecharge-=1;
                    System.out.println("Your remaining balance is Rs. " + Balance);
                
                   break;
                default:
                    System.out.println("Invalid choice. Please select a valid recharge plan.");
                    continue; 
                

            }
            System.out.println("Do you want to recharge again yes==1 and no==0 ?");
            int ans=sc.nextInt();

            if(ans>=1){
                AnotherRecharge+=1;

            }else{

                System.out.println("Thank you for using our Services!!");
            }

        }
    }
    

}
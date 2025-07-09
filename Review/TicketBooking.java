//package Review;
import java.util.*;
public class TicketBooking{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int total_no_of_seats=10;
        int total_bill=0;
        System.out.println("Types of seats Available are:");
        System.out.println("Platinum seat is of Rs.2000/per person");
        System.out.println("Golden seat is of Rs.1000/per person");
        System.out.println("Silver seat is of Rs.500/per person");
        int seats_left=0;

        while(total_no_of_seats<=10){
            System.out.println("Enter 1 for Platinum");
            System.out.println("Enter 2 for Gold");
            System.out.println("Enter 3 for Silver");
            switch (sc.nextInt()) {
                case 1:
                        System.out.println("YOUR PLATINUM SEAT IS SUCCESSFULLY BOOKED!!");
                        System.out.println("Thank You for using our services.");
                        seats_left=total_no_of_seats-1;
                        total_no_of_seats--;
                        System.out.println("No.of empty seat left is "+seats_left);
                        total_bill+=2000;
                        System.out.println("total bill "+total_bill);
                    
                    break;
                case 2:
                        System.out.println("YOUR GOLDEN SEAT IS SUCCESSFULLY BOOKED!!");
                        System.out.println("Thank You for using our services.");
                        seats_left=total_no_of_seats-1;
                        total_no_of_seats--;
                        System.out.println("No.of empty seat left is "+seats_left);
                        total_bill+=1000;
                        System.out.println("total bill "+total_bill);
                    
                    break;
                case 3:
                        System.out.println("YOUR SILVER SEAT IS SUCCESSFULLY BOOKED!!");
                        System.out.println("Thank You for using our services.");
                        seats_left=total_no_of_seats-1;
                        total_no_of_seats--;
                        System.out.println("No.of empty seat left is "+seats_left);
                        total_bill+=500;
                        System.out.println("total bill "+total_bill);
                    
                    break;    
                default:
                    break;
            }
            System.out.println("If you want to book another seat yes==1 or no==0 ?");
            int userDemand=sc.nextInt();
            
            if(userDemand==1){
                System.out.println("I want to Book another seat ");
                continue;
            }else{
                System.out.println("I don't want another seat");
                break;

            }

        }
        if(total_no_of_seats==0){
           System.out.println("All Tickets Are Booked");
        }
        
    }
}
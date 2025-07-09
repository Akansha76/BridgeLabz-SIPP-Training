//package Review;
import java.util.*;
public class CoffeeShop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Types coffee Available-");
        System.out.println("Latte 100ml 400Rs/100ml");
        System.out.println("Americano 100ml 500Rs/100ml");
        System.out.println("cappuccino 100ml 600Rs/100ml");
        boolean user=true;
        int GST=18/100;//18%per ml
        while(true){
            int bill=0;
            System.out.println("Enter 1 for Latte 100ml 400Rs/100ml");
            System.out.println("Enter 2 for Americano 100ml 500Rs/100ml");
            System.out.println("Enter 3 for cappuccino 100ml 600Rs/100ml");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Your Latte Coffee of 100ml 400Rs/100ml is READY!!");
                    bill=bill+400+(GST*400);
                    System.out.println("Your bill Rs."+bill);
                    break;
                case 2:
                    System.out.println("Your Americano of 100ml 500Rs/100ml is READY!!");
                    bill=bill+500+(GST*500);
                    System.out.println("Your bill Rs."+bill);
                    break;
                case 3:
                    System.out.println("Your cappuccino of 100ml 600Rs/100ml is READY!!");
                    bill=bill+600+(GST*600);
                    System.out.println("Your bill Rs."+bill);
                    break;
            
                default:
                    break;
            }
            System.out.println("Is there any other Customer exit/notexit ");
            String ans=sc.next();
            if(ans.equals("exit")) {
                System.out.println("There is no other customer");
                break;
            }else{
                continue;
            }
            
        }
        
    }   
}

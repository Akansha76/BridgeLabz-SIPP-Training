import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("\nEnter unit price:");
        double unitPrice = sc.nextDouble();
        System.out.println("Enter quantity:");
        int quantity = sc.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.printf("The total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f\n", totalPrice, quantity, unitPrice);

        
    }
}

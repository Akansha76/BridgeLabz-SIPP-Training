import java.util.*;
public class StudentFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter Student Fee (INR):");
        double fee = sc.nextDouble();
        System.out.println("Enter Discount Percentage:");
        double discountPercent = sc.nextDouble();
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }

}

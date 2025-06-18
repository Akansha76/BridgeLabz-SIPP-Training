import java.util.Scanner;

public class SmallestLargestNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the num of element");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();

        int smallestNum=smallest(n1, n2, n3);
        int largestNum=largest(n1, n2, n3);
        System.out.println(null + "Smallest Number is: " + smallestNum);
        System.out.println(null + "Largest Number is: " + largestNum);

    }
    public static int smallest(int a, int b, int c) {
        
       return Math.min(a,Math.min(b,c));
    }
    public static int largest(int a, int b, int c) {
        
        return Math.max(a,Math.max(b,c));
    }

}

import java.util.Scanner;
public class HandShake {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int ans=handshake(num);
        System.out.println("POssible HandShake "+ans);


    }
    public static int handshake(int n){
        return (n*(n-1))/2;
    }
}

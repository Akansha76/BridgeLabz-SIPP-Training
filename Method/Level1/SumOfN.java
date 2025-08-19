import java.util.*; 
public class SumOfN {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=sum(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + ans);



    }
    public static int sum(int n){
        int s=0;
        for(int i=1;i<=n;i++){
            s=s+i;

        }
        return s;
    }
}

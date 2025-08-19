package Practice2;

public class Fibonacci {
    public static void main(String[] args) {
        int ans=fibb(7);
        System.out.println("Fibonacci of 7 is: " + ans);
    }

public static  int fibb(int n){
    if(n==1||n==0){
        return n;

    }
    return fibb(n-1)+fibb(n-2);
}
}

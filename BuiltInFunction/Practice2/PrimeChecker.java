package Practice2;

public class PrimeChecker {
    public static void main(String[] args) {
        int n=29;
        boolean ans=isPrime(n);
        System.out.println(ans);
    }
    

public static boolean isPrime(int n){
    if(n<=1){
        return false;
    }
    for(int i=2;i<=Math.sqrt(n);i++){
        if(n%i==0){
            return false;
        }
    }
    return true;
}
}
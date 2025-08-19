package Practice2;
public class Palindrone{
    public static void main(String[] args) {
        String s="hello";
        boolean ans=check(s);
        System.out.println("Is the string a palindrome? " + ans);
    }
    public static boolean check(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
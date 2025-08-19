public class RemoveDuplicate{
    public static void main(String[] args){
        String s="hello";
        String ans="";
       
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(ans.indexOf(c)==-1){
                ans=ans+c;

            }
        }
        System.out.println("String after removing duplicates: " + ans);
    }
}

import java.util.Scanner;

public class NumOfRound {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int s1=sc.nextInt();
        int s2=sc.nextInt();
        int s3=sc.nextInt();
        int distance_in_cm=5;
        int ans=NumOfRound(s1, s2, s3, distance_in_cm);
        System.out.println("Number of Rounds: " + ans);

    }
    public static int NumOfRound(int s1,int s2,int s3,int distance_in_cm){
        int total_distance = s1 + s2 + s3;
        int num_of_rounds = total_distance / distance_in_cm;
        return num_of_rounds;
    }
}

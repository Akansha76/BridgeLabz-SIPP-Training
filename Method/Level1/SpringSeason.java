import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        int day=sc.nextInt();
        String result = isSpring(month, day);
        System.out.println(result);

    }
    public static String isSpring(int month, int day) {
        if (month == 3 && day >= 20 || month == 4 || month == 5 || (month == 6 && day < 21)) {
            return "Spring";
        } else {
            return "Not Spring";
        }
    }
}

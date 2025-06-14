package Level2;

import java.util.Scanner;

class FriendsAgeHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar, Akbar, Anthony: ");
        int amarAge = sc.nextInt(), akbarAge = sc.nextInt(), anthonyAge = sc.nextInt();

        System.out.print("Enter height of Amar, Akbar, Anthony: ");
        int amarHeight = sc.nextInt(), akbarHeight = sc.nextInt(), anthonyHeight = sc.nextInt();

        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        if (youngestAge == amarAge) System.out.println("Amar is the youngest.");
        else if (youngestAge == akbarAge) System.out.println("Akbar is the youngest.");
        else System.out.println("Anthony is the youngest.");

        int tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        if (tallestHeight == amarHeight) System.out.println("Amar is the tallest.");
        else if (tallestHeight == akbarHeight) System.out.println("Akbar is the tallest.");
        else System.out.println("Anthony is the tallest.");
    }
}


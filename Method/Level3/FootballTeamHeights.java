package Level3;
import java.util.*;
import java.util.Random;

public class FootballTeamHeights {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] heights = new int[11];

       
        for (int i = 0; i < heights.length; i++) {
            int height=sc.nextInt();
            if(height < 150 || height > 250) {
                System.out.println("Invalid height. Please enter a height between 150 and 250 cm.");
                i--; // Decrement i to repeat this iteration
            } else {
                heights[i] = height;
            }
            
        }

        // Display the generated heights
        System.out.println("Player Heights (in cm):");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println("\n");

        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        // Display results
        System.out.println("Sum of Heights: " + sum + " cm");
        System.out.printf("Mean Height: %.2f cm\n", mean);
        System.out.println("Shortest Height: " + shortest + " cm");
        System.out.println("Tallest Height: " + tallest + " cm");
    }

    // Method to find sum of all heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    // Method to find mean height
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    // Method to find shortest height
    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }

    // Method to find tallest height
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }
}

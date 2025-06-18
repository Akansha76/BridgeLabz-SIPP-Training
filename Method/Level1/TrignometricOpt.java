import java.util.Scanner;

public class TrignometricOpt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double angle =sc.nextInt(); // Example angle in degrees
        double radians = Math.toRadians(angle); // Convert degrees to radians

        TrignometricOpt trigOpt = new TrignometricOpt();
        double[] results = trigOpt.calculateTrigonometricFunctions(angle);
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
    }
    public double[] calculateTrigonometricFunctions(double angle){
        double radians = Math.toRadians(angle); // Convert degrees to radians
        double[] results = new double[3];
        
        results[0] = Math.sin(radians); // Sine
        results[1] = Math.cos(radians); // Cosine
        results[2] = Math.tan(radians); // Tangent
        
        return results;
    }
}

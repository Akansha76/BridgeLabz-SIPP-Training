// Write a program to find the factors of a number and perform various tasks using the factors array
// Hint => 
// Method to find factors of a number and return them as an array. Note there are 2 for loops: one for the count and another for finding the factor and storing in the array
// Method to find the greatest factor of a Number using the factors array
// Method to find the sum of the factors using factors array and return the sum
// Method to find the product of the factors using factors array and return the product
// Method to find the product of the cube of the factors using the factors array. Use Math.pow() 



package Level3;

public class FactorOfNum {
    public static void main(String[] args) {
        int number = 28; // Example number
        int[] factors = findFactors(number);
        
        System.out.println("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        
        System.out.println("\nGreatest Factor: " + greatestFactor(factors));
        System.out.println("Sum of Factors: " + sumOfFactors(factors));
        System.out.println("Product of Factors: " + productOfFactors(factors));
        System.out.println("Product of Cube of Factors: " + productOfCubeOfFactors(factors));
    }
    public static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }
        
        return factors;
    }
    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int factor : factors) {
            if (factor > max) {
                max = factor;
            }
        }
        return max;
    }
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }
    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1.0;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }
    
}

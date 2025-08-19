package Level3;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

  
    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // values between 0-9
        return matrix;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                sum[i][j] = a[i][j] + b[i][j];

        return sum;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] diff = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                diff[i][j] = a[i][j] - b[i][j];

        return diff;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int common = a[0].length;

        int[][] product = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < common; k++)
                    product[i][j] += a[i][k] * b[k][j];

        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions for addition & subtraction
        System.out.print("Enter rows and columns for Matrix A & B (same size): ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrixA = generateMatrix(rows, cols);
        int[][] matrixB = generateMatrix(rows, cols);

        System.out.println("\nMatrix A:");
        printMatrix(matrixA);

        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        int[][] sum = addMatrices(matrixA, matrixB);
        int[][] diff = subtractMatrices(matrixA, matrixB);

        System.out.println("\nMatrix A + Matrix B:");
        printMatrix(sum);

        System.out.println("\nMatrix A - Matrix B:");
        printMatrix(diff);

        // Input dimensions for multiplication
        System.out.print("\nEnter rows and columns for Matrix X: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.print("Enter columns for Matrix Y (rows will be " + c1 + "): ");
        int c2 = sc.nextInt();

        int[][] matrixX = generateMatrix(r1, c1);
        int[][] matrixY = generateMatrix(c1, c2);

        System.out.println("\nMatrix X:");
        printMatrix(matrixX);

        System.out.println("\nMatrix Y:");
        printMatrix(matrixY);

        int[][] product = multiplyMatrices(matrixX, matrixY);

        System.out.println("\nMatrix X * Matrix Y:");
        printMatrix(product);
    }
}


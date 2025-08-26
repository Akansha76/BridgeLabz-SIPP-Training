import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        String inputFile = "D:/Collection/JavaStream/source.txt";
        String outputFile = "D:/Collection/JavaStream/lowercase.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert uppercase to lowercase
                writer.write(line.toLowerCase());
                writer.newLine(); // keep line breaks
            }

            System.out.println(" File converted successfully! Output: " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println(" Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" Error processing file: " + e.getMessage());
        }
    }
}

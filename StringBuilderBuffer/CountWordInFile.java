package StringBuilderBuffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {
    public static void main(String[] args) {
        String filePath = "example.txt";  // Change to your file path
        String targetWord = "java";       // Word to count (case-sensitive)

        int count = 0;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                // Split line into words using space and punctuation
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();
            fr.close();

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}


import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordCountTop5 {
    private static final String FILE_PATH = "D:/Collection/JavaStream/sample.txt";

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                // Split words by non-alphabetic characters
                String[] words = line.toLowerCase().split("[^a-zA-Z]+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort by frequency (descending)
            List<Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Count total words
            int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();

            System.out.println(" Total Words in File: " + totalWords);
            System.out.println("\n Top 5 Most Frequent Words:");

            int count = 0;
            for (Entry<String, Integer> entry : sortedList) {
                if (count == 5) break;
                System.out.println(entry.getKey() + " -> " + entry.getValue());
                count++;
            }

        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }
}

import java.util.*;
import java.util.stream.*;
public class WordFrequency {
    public static void main(String[] args) {
        String sentence = "java stream api makes coding easier java java";

        Map<String, Long> freq =
            Arrays.stream(sentence.split(" "))
                  .collect(Collectors.groupingBy(
                      word -> word,
                      Collectors.counting()
                  ));

        System.out.println(freq);
    }
}

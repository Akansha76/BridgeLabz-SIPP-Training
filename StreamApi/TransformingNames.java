package StreamApi;

// Stream API Example 5: Transforming Names for Display

import java.util.*;

public class TransformingNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Akanksha", "ravi", "meena", "vikram");

        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}


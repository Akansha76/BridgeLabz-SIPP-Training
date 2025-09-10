import java.util.*;
import java.util.stream.*;

public class DublicateFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 1);

        List<Integer> duplicates = numbers.stream()
            .filter(n -> Collections.frequency(numbers, n) > 1)
            .distinct()
            .collect(Collectors.toList());

        System.out.println(duplicates);
    }
}

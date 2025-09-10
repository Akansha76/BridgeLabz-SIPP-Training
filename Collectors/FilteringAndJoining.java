import java.util.*;
import java.util.stream.*;
public class FilteringAndJoining {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Angela");

        String result = names.stream()
                             .filter(n -> n.startsWith("A"))
                             .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}


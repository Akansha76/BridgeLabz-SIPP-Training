import java.util.*;
import java.util.stream.*;
class Emp {
    int id;
    String name;
    String dept;
    Emp(int id, String name, String dept) {
        this.id = id; this.name = name; this.dept = dept;
    }
}

public class Q10 {
    public static void main(String[] args) {
        List<Emp> employees = Arrays.asList(
            new Emp(1, "Alice", "IT"),
            new Emp(2, "Bob", "Finance"),
            new Emp(3, "Charlie", "IT"),
            new Emp(4, "David", "HR"),
            new Emp(5, "Eve", "Finance")
        );

        Map<String, Long> deptCount =
            employees.stream()
                     .collect(Collectors.groupingBy(
                         e -> e.dept,
                         Collectors.counting()
                     ));

        System.out.println(deptCount);
    }
}


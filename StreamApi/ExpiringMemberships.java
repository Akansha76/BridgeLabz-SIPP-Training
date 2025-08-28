package StreamApi;

// Stream API Example 4: Filtering Expiring Memberships

import java.time.LocalDate;
import java.util.*;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " (Expiry: " + expiryDate + ")";
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Alice", LocalDate.now().plusDays(10)),
            new Member("Bob", LocalDate.now().plusDays(40)),
            new Member("Charlie", LocalDate.now().plusDays(20)),
            new Member("Diana", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();

        members.stream()
               .filter(m -> !m.expiryDate.isBefore(today)
                         && m.expiryDate.isBefore(today.plusDays(30)))
               .forEach(System.out::println);
    }
}

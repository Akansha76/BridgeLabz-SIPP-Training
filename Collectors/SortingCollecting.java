import java.util.*;
import java.util.stream.*;

class Book {
    String title, author;
    double price;
    Book(String title, String author, double price) {
        this.title = title; this.author = author; this.price = price;
    }
}

public class SortingCollecting{
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Author 1", 20),
            new Book("Book B", "Author 2", 35),
            new Book("Book C", "Author 3", 15)
        );

        List<String> sortedTitles = books.stream()
            .sorted(Comparator.comparingDouble(b -> -b.price))
            .map(b -> b.title)
            .collect(Collectors.toList());

        System.out.println(sortedTitles);
    }
}

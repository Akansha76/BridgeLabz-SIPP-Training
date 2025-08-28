package StreamApi;

// Stream API Example 1: Top 5 Trending Movies

import java.util.*;

class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + " (Rating: " + rating + ", Year: " + year + ")";
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 9.0, 2022),
            new Movie("Movie C", 7.8, 2024),
            new Movie("Movie D", 8.9, 2024),
            new Movie("Movie E", 8.3, 2021),
            new Movie("Movie F", 9.2, 2023),
            new Movie("Movie G", 8.7, 2024)
        );

        movies.stream()
              .sorted(Comparator.comparingDouble((Movie m) -> m.rating)
                                .thenComparingInt(m -> -m.year)
                                .reversed())
              .limit(5)
              .forEach(System.out::println);
    }
}

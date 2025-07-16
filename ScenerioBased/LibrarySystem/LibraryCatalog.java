package ScenerioBased.LibrarySystem;

import java.util.*;

public class LibraryCatalog {
    private Map<String, LinkedList<Book>> genreMap;
    private Set<Book> bookSet; // Optional: For avoiding duplication

    public LibraryCatalog() {
        genreMap = new HashMap<>();
        bookSet = new HashSet<>();
    }

    // Add a book to the catalog
    public void addBook(String genre, Book book) {
        if (bookSet.contains(book)) {
            System.out.println("Book already exists: " + book);
            return;
        }

        genreMap.putIfAbsent(genre, new LinkedList<>());
        genreMap.get(genre).add(book);
        bookSet.add(book);
        System.out.println("Added: " + book + " to genre: " + genre);
    }

    // Borrow a book (remove it temporarily)
    public void borrowBook(String genre, String title) {
        LinkedList<Book> list = genreMap.get(genre);
        if (list == null) {
            System.out.println("Genre not found.");
            return;
        }

        for (Book book : list) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                list.remove(book);
                System.out.println("Borrowed: " + book);
                return;
            }
        }
        System.out.println("Book not found in genre: " + genre);
    }

    // Return a book (add it back)
    public void returnBook(String genre, Book book) {
        genreMap.putIfAbsent(genre, new LinkedList<>());
        genreMap.get(genre).add(book);
        bookSet.add(book);
        System.out.println("Returned: " + book + " to genre: " + genre);
    }

    // Display the catalog
    public void displayCatalog() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : genreMap.keySet()) {
            System.out.println("- " + genre + ":");
            for (Book book : genreMap.get(genre)) {
                System.out.println("  " + book);
            }
        }
    }
}

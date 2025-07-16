package ScenerioBased.LibrarySystem;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b4 = new Book("The Hobbit", "J.R.R. Tolkien"); // Duplicate

        catalog.addBook("Fantasy", b1);
        catalog.addBook("Dystopian", b2);
        catalog.addBook("Classic", b3);
        catalog.addBook("Fantasy", b4); // Should be rejected

        catalog.displayCatalog();

        catalog.borrowBook("Fantasy", "The Hobbit");
        catalog.displayCatalog();

        catalog.returnBook("Fantasy", b1);
        catalog.displayCatalog();
    }
}

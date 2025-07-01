import java.util.ArrayList;

public class LibraryAggregationDemo {

    /* ---------- Book ---------- */
    static class Book {
        private final String title;
        private final String author;

        public Book(String title, String author) {
            this.title  = title;
            this.author = author;
        }

        public void display() {
            System.out.println("Book"+ title + " — " + author);
        }

        // Getters in case you need them later
        public String getTitle()  { return title;  }
        public String getAuthor() { return author; }
    }

    /* ---------- Library (aggregates Books) ---------- */
    static class Library {
        private final String name;
        private final ArrayList<Book> books;

        public Library(String name) {
            this.name  = name;
            this.books = new ArrayList<>();
        }

        /* Aggregation: the Library only *refers* to existing Book objects. */
        public void addBook(Book book) {
            books.add(book);
        }

        public void showCollection() {
            System.out.println("\n Library: " + name);
            if (books.isEmpty()) {
                System.out.println("   — no books yet —");
            } else {
                books.forEach(Book::display);
            }
        }

        public String getName() { return name; }
    }

    /* ---------- Demo ---------- */
    public static void main(String[] args) {

        // Create independent Book objects (they exist on their own)
        Book alchemist   = new Book("The Alchemist", "Paulo Coelho");
        Book nineteen84  = new Book("1984", "George Orwell");
        Book mockingbird = new Book("To Kill a Mockingbird", "Harper Lee");

        // Create two distinct libraries
        Library central   = new Library("Central Library");
        Library community = new Library("Community Library");

        // Aggregate: add (share) books
        central.addBook(alchemist);
        central.addBook(nineteen84);

        community.addBook(nineteen84);   // same book shared!
        community.addBook(mockingbird);

        // Display collections
        central.showCollection();
        community.showCollection();
    }
}
